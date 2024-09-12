package main

import (
	"fmt"
)

func countIslands(grid [][]int) int {

	count := 0

	visited := make([][]bool, len(grid))

	for i := 0; i < len(visited); i++ {
		visited[i] = make([]bool, len(grid[0]))
	}

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {

			if grid[i][j] == 1 && !visited[i][j] {
				count++
				dfs(grid, i, j, visited)
			}
		}

	}
	return count

}

func dfs(grid [][]int, i int, j int, visited [][]bool) {

	visited[i][j] = true

	rowMoves := []int{1, -1, 0, 0}
	colMoves := []int{0, 0, 1, -1}

	for k := 0; k < 4; k++ {

		if isSafe(grid, i+rowMoves[k], j+colMoves[k], visited) {
			dfs(grid, i+rowMoves[k], j+colMoves[k], visited)
		}

	}

}

func isSafe(grid [][]int, row, col int, visited [][]bool) bool {
	return (row >= 0) && (col >= 0) && row < len(grid) &&
		col < len(grid[0]) && grid[row][col] == 1 && !visited[row][col]
}

func main() {
	matrix := [][]int{
		{1, 1, 0, 0, 0},
		{1, 1, 0, 0, 1},
		{1, 0, 0, 1, 1},
		{0, 0, 0, 1, 0},
		{1, 0, 1, 1, 1},
	}

	fmt.Println("Number of islands is:", countIslands(matrix))
}
