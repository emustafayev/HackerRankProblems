package main

import "fmt"

func main() {

	fmt.Println(canVisitAllRooms([][]int{{1}, {2}, {3}, {}}))

}

func canVisitAllRooms(rooms [][]int) bool {

	visited := make([]bool, len(rooms))
	dfs(rooms, visited, 0)
	for i := 0; i < len(visited); i++ {
		if !visited[i] {
			return false
		}
	}
	return true

}

func dfs(rooms [][]int, visited []bool, roomIndex int) {
	if visited[roomIndex] {
		return
	}
	visited[roomIndex] = true
	for _, key := range rooms[roomIndex] {
		dfs(rooms, visited, key)
	}
}

func canVisitAllRooms2(rooms [][]int) bool {

	visited := make([]bool, len(rooms))
	visited[0] = true

	var stack []int
	stack = append(stack, 0)

	for len(stack) > 0 {

		curr := stack[len(stack)-1]
		stack = stack[:len(stack)-1]

		for _, key := range rooms[curr] {
			if !visited[key] {
				stack = append(stack, key)
				visited[key] = true
			}
		}

	}

	return false
}
