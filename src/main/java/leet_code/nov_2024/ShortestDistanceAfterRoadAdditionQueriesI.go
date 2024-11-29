package main

import "fmt"

func main() {

	fmt.Print(shortestDistanceAfterQueries2(5, [][]int{{2, 4}, {0, 2}, {0, 4}}))

}

func shortestDistanceAfterQueries(n int, queries [][]int) []int {

	adj := make([][]int, n)
	for i := range adj {
		adj[i] = []int{i + 1}
	}

	searchTarget := func() int {
		queue := [][]int{{0, 0}} // node, length

		visited := make(map[int]bool)
		visited[0] = true

		for len(queue) > 0 {

			node, lengthToNode := queue[0][0], queue[0][1]
			queue = queue[1:]

			if node == n-1 {
				return lengthToNode
			}

			//continue searching neighbours

			for _, nei := range adj[node] {
				if !visited[nei] {
					queue = append(queue, []int{nei, lengthToNode + 1})
					visited[nei] = true
				}
			}

		}

		return -1

	}

	var res []int

	for _, q := range queries {
		src, dst := q[0], q[1]
		adj[src] = append(adj[src], dst)
		res = append(res, searchTarget())
	}

	return res
}

func updateDistances(graph [][]int, current int, distances []int) {
	newDist := distances[current] + 1

	for _, neighbor := range graph[current] {
		if distances[neighbor] <= newDist {
			continue
		}

		distances[neighbor] = newDist
		updateDistances(graph, neighbor, distances)
	}
}

func shortestDistanceAfterQueries2(n int, queries [][]int) []int {
	distances := make([]int, n)
	for i := range distances {
		distances[i] = n - 1 - i
	}

	graph := make([][]int, n)
	for i := 0; i < n-1; i++ {
		graph[i+1] = append(graph[i+1], i)
	}

	fmt.Println(graph)

	answer := make([]int, 0, len(queries))

	for _, query := range queries {
		source, target := query[0], query[1]
		graph[target] = append(graph[target], source)

		if distances[target]+1 < distances[source] {
			distances[source] = distances[target] + 1
		}

		updateDistances(graph, source, distances)
		answer = append(answer, distances[0])
	}

	return answer
}
