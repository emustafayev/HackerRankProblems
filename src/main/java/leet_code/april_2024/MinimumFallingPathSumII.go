package main

import (
	"fmt"
	"math"
)

func main() {

	fmt.Println(minFallingPathSum(
		[][]int{
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9},
		},
	))
}

func minFallingPathSum(grid [][]int) int {

	var dp [][]int

	for i := 0; i < len(grid); i++ {
		var row []int
		for i := 0; i < len(grid[0]); i++ {
			row = append(row, -1)
		}
		dp = append(dp, row)
	}

	dp[0] = grid[0]

	for i := 1; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {

			currentOptimal := math.MaxInt
			current := grid[i][j]

			for k := 0; k < len(grid); k++ {
				previousOptimal := dp[i-1][k]
				if j != k {
					currentOptimal = minFalling(currentOptimal, current+previousOptimal)
				}
			}
			dp[i][j] = currentOptimal
		}
	}

	res := math.MaxInt
	for i := 0; i < len(grid); i++ {
		res = minFalling(res, dp[len(grid)-1][i])
	}

	return res
}

func minFalling(a, b int) int {
	if a > b {
		return b
	}
	return a
}
