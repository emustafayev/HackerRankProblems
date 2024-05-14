package main

import (
	"fmt"
)

func main() {

	fmt.Println(getMaximumGold([][]int{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}))
}

func getMaximumGold(g [][]int) int {
	maxGold := 0
	for i := range g {
		for j := range g[i] {
			if g[i][j] != 0 {
				gold := backtrack(g, i, j)
				if gold > maxGold {
					maxGold = gold
				}
			}
		}
	}
	return maxGold
}

func backtrack(g [][]int, r, c int) int {
	if r < 0 || r >= len(g) || c < 0 || c >= len(g[0]) || g[r][c] == 0 {
		return 0
	}

	currGold := g[r][c]
	g[r][c] = 0

	maxGold := 0
	for _, dir := range [][]int{{0, 1}, {0, -1}, {1, 0}, {-1, 0}} {
		newR, newC := r+dir[0], c+dir[1]
		maxGold = max(maxGold, currGold+backtrack(g, newR, newC))
	}

	g[r][c] = currGold
	return maxGold
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
