package main

import (
	"math"
	"slices"
	s "sort"
)

func main() {

}

func compareBySecondElement(a, b []int) int {
	if a[1] < b[1] {
		return -1
	} else if a[1] > b[1] {
		return 1
	}
	return 0
}

func findLongestChain(pairs [][]int) int {
	slices.SortFunc(pairs, compareBySecondElement)

	n := len(pairs)

	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, n+1) // Size n+1 to handle edge case where prevIndex is -1
		for j := range dp[i] {
			dp[i][j] = -1
		}
	}

	return solveCBSE(pairs, 0, -1, dp)
}

func solveCBSE(pairs [][]int, i, prevIndex int, dp [][]int) int {

	if len(pairs) <= i {
		return 0
	}

	if dp[i][prevIndex+1] != -1 {
		return dp[i][prevIndex+1]
	}

	dontTake := solveCBSE(pairs, i+1, prevIndex, dp)

	take := 0

	if prevIndex == -1 || pairs[i][0] > pairs[prevIndex][1] {
		take = 1 + solveCBSE(pairs, i+1, i, dp)
	}
	dp[i][prevIndex+1] = max(take, dontTake)
	return dp[i][prevIndex+1]
}

func findLongestChain2(pairs [][]int) int {
	s.Slice(pairs, func(i, j int) bool {
		return pairs[i][1] < pairs[j][1]
	})

	curr, ans := math.MinInt32, 0

	for _, pair := range pairs {
		if curr < pair[0] {
			curr = pair[1]
			ans++
		}
	}

	return ans
}
