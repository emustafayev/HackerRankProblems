package main

import "fmt"

func main() {

	input := [][]byte{
		{
			'1', '1', '1', '1', '0',
		},
		{
			'1', '1', '0', '1', '0',
		},
		{
			'1', '1', '0', '0', '0',
		},
		{
			'0', '0', '0', '0', '0',
		},
	}

	fmt.Println(numIslands(input))
}

func numIslands(grid [][]byte) int {

	var dfs func(i, j int)

	dfs = func(row, col int) {
		if row < 0 || col < 0 || row >= len(grid) || col >= len(grid[0]) || grid[row][col] == '0' {
			return
		}
		grid[row][col] = '0'
		dfs(row+1, col)
		dfs(row-1, col)
		dfs(row, col+1)
		dfs(row, col-1)
	}

	res := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if grid[i][j] == '1' {
				dfs(i, j)
				res++
			}

		}
	}
	return res
}
