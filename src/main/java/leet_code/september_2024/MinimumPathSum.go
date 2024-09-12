package main

func minPathSum(grid [][]int, x, y, maxSum int) int {

	iLen, jLen := len(grid), len(grid[0])
	for i := 0; i < iLen; i++ {
		for j := 0; j < jLen; j++ {
			switch {
			case j == 0 && i != 0:
				grid[i][j] += grid[i-1][j]
			case i == 0 && j != 0:
				grid[i][j] += grid[i][j-1]
			case i != 0 && j != 0:
				grid[i][j] = min(grid[i][j]+grid[i-1][j], grid[i][j]+grid[i][j-1])
			}

		}
	}
	return grid[iLen-1][jLen-1]
}

func min(a, b int) int {

	if a < b {
		return a
	}
	return b
}
