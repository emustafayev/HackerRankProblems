package main

import (
	"fmt"
)

func main() {

	board := [][]byte{
		{'A', 'B', 'C', 'E'},
		{'S', 'F', 'C', 'S'},
		{'A', 'D', 'E', 'E'},
	}

	fmt.Println(exist(board, "ABCCED"))
}

func exist(board [][]byte, word string) bool {

	i := 0
	j := 0
	runner := 0
	var visited [][]bool
	for i := 0; i < len(board); i++ {
		var arr []bool
		for j := 0; j < len(board[0]); j++ {
			arr = append(arr, false)
		}
		visited = append(visited, arr)
	}

	fmt.Println(visited[0][0])
	return search(board, word, visited, i, j, runner)
}

var directions = [][]int{{0, 1}, {1, 0}, {-1, 0}, {0, -1}}

func search(board [][]byte, word string, visited [][]bool, i, j, runner int) bool {
	fmt.Println(i, j)
	fmt.Println(visited[0][0])
	if runner == len(word) {
		return true
	}
	if board[i][j] == word[runner] {
		runner++
	} else {
		runner = 0
	}

	for _, dir := range directions {
		if moveable(dir, board, i, j) {
			if !visited[i][j] {
				visited[i][j] = true
				res := search(board, word, nil, i+dir[0], j+dir[1], runner)
				if res {
					return res
				}
			}
		}
	}
	visited[i][j] = false
	return false
}

func moveable(dir []int, board [][]byte, i, j int) bool {
	if (i+dir[0] < len(board) && i+dir[0] >= 0) &&
		j+dir[1] < len(board[0]) && j+dir[1] > 0 {
		return true
	}
	return false
}
