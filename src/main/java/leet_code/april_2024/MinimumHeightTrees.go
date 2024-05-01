package main

import "math"

func main() {

}

//5,6,8,10

func findMinHeightTrees(n int, edges [][]int) []int {
	counts := make([]int, n)
	links := make([]int, n)
	for _, edge := range edges {
		links[edge[0]] ^= edge[1]
		counts[edge[0]]++
		links[edge[1]] ^= edge[0]
		counts[edge[1]]++
	}
	queue := make([]int, 0)
	dists := make([]int, n)
	for i := 0; i < n; i++ {
		if counts[i] == 1 {
			queue = append(queue, i)
		}
	}
	stp := 1
	for len(queue) > 0 {
		size := len(queue)
		for j := 0; j < size; j++ {
			tmp := queue[0]
			queue = queue[1:]
			links[links[tmp]] ^= tmp
			counts[links[tmp]]--
			if counts[links[tmp]] == 1 {
				dists[links[tmp]] = int(math.Max(float64(stp), float64(dists[links[tmp]])))
				queue = append(queue, links[tmp])
			}
		}
		stp++
	}
	maxDist := 0
	for _, dist := range dists {
		if dist > maxDist {
			maxDist = dist
		}
	}
	res := make([]int, 0)
	for i, dist := range dists {
		if dist == maxDist {
			res = append(res, i)
		}
	}
	return res
}

func findMinHeightTrees2(n int, edges [][]int) []int {

	count := make([]int, n)
	links := make([]int, n)

	for _, edge := range edges {
		//bitwise XOR stores the elements
		links[edge[0]] ^= edge[1] // store edge[1] as a neighbour for edge[0]
		links[edge[1]] ^= edge[0]

		count[edge[0]]++
		count[edge[1]]++

	}

	queue := make([]int, 0)

	dists := make([]int, n)

	for i := 0; i < n; i++ { //"i" is actually nodes itself.
		if count[i] == 1 {
			queue = append(queue, i)
		}
	}

	stp := 1

	if len(queue) > 1 {
		tmp := queue[0]
		queue = queue[1:]
		links[links[tmp]] ^= tmp

	}

	return nil
}
