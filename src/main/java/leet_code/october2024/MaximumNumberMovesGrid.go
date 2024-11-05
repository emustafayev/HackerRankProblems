package main

import "fmt"

func main() {

	fmt.Println(maxMoves([][]int{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}))
}

func maxMoves(grid [][]int) int {

	n := len(grid)
	res := 0

	for i := 0; i < n; i++ {
		res = max(res, track(i, 0, grid, 0))
	}

	return res
}

func track(r, c int, grid [][]int, moves int) int {

	maxM := 0

	if r-1 >= 0 && r-1 < len(grid) && c+1 >= 0 && c+1 < len(grid[0]) &&
		grid[r][c] < grid[r-1][c+1] {
		maxM = max(maxM, track(r-1, c+1, grid, moves+1))
	} else if (r >= 0 && r < len(grid) && c+1 >= 0 && c+1 < len(grid[0])) &&
		grid[r][c] < grid[r][c+1] {
		maxM = max(maxM, track(r, c+1, grid, moves+1))
	} else if (r+1 >= 0 && r+1 < len(grid) && c+1 >= 0 && c+1 < len(grid[0])) &&
		grid[r][c] < grid[r+1][c+1] {
		maxM = max(maxM, track(r+1, c+1, grid, moves+1))
	} else {
		return moves
	}

	return maxM
}

func maxMoves2(grid [][]int) int {
	m := len(grid)
	n := len(grid[0])
	res := 0
	dp := make([]int, m)

	for j := 1; j < n; j++ {
		leftTop := 0
		found := false

		for i := 0; i < m; i++ {
			cur := -1
			nxtLeftTop := dp[i]

			if i-1 >= 0 && leftTop != -1 && grid[i][j] > grid[i-1][j-1] {
				cur = max(cur, leftTop+1)
			}

			if dp[i] != -1 && grid[i][j] > grid[i][j-1] {
				cur = max(cur, dp[i]+1)
			}

			if i+1 < m && dp[i+1] != -1 && grid[i][j] > grid[i+1][j-1] {
				cur = max(cur, dp[i+1]+1)
			}

			dp[i] = cur
			found = found || (dp[i] != -1)
			leftTop = nxtLeftTop
		}

		if !found {
			break
		}
		res = j
	}

	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func maxMoves3(grid [][]int) int {
	m, n := len(grid), len(grid[0])
	dp := make([][]int, m)
	for i := range dp {
		dp[i] = make([]int, n)
	}
	maxMoves := 0

	for col := n - 2; col >= 0; col-- {
		for row := 0; row < m; row++ {
			if row > 0 && grid[row][col] < grid[row-1][col+1] {
				dp[row][col] = max(dp[row][col], dp[row-1][col+1]+1)
			}
			if grid[row][col] < grid[row][col+1] {
				dp[row][col] = max(dp[row][col], dp[row][col+1]+1)
			}
			if row < m-1 && grid[row][col] < grid[row+1][col+1] {
				dp[row][col] = max(dp[row][col], dp[row+1][col+1]+1)
			}
		}
	}

	for row := 0; row < m; row++ {
		maxMoves = max(maxMoves, dp[row][0])
	}
	return maxMoves
}
