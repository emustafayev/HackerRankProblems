package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Print(findCheapestPrice(4, [][]int{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 2, 1))
}

func findCheapestPrice(n int, flights [][]int, src int, dst int, k int) int {

	res := 0

	graph := make([][][]int, n)

	for _, flight := range flights {

		from := flight[0]
		to := flight[1]
		price := flight[2]
		graph[from] = append(graph[from], []int{to, price})
		res = min(dfs(k, 0, dst, src, graph), res)

	}

	fmt.Println(graph)

	return res
}

func dfs(k, runningPrice, dst, curr int, graph [][][]int) int {

	if curr == dst {
		return runningPrice
	}

	if k < 0 {
		return math.MaxInt32
	}

	//Continue searching
	maxP := math.MinInt32

	for _, nei := range graph[curr] {
		maxP = max(dfs(k-1, runningPrice+nei[1], dst, nei[0], graph), maxP)
	}

	return maxP
}
