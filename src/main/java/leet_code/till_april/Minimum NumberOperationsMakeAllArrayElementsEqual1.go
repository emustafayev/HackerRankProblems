package main

import "math"

//https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/description/

func main() {

}

func gcd(a, b int) int {
	for b > 0 {
		a, b = b, a%b
	}

	return a
}

func min(a, b int) int {
	if a < b {
		return a
	}

	return b
}

func minOperations(nums []int) int {

	n := len(nums)
	ones := 0

	for _, num := range nums {
		if num == 1 {
			ones++
		}
	}

	// if there is 1s, there are gcds garanteed to be 1
	// so just flip any other non 1s to 1s
	if ones > 0 {
		return n - ones
	}

	res := math.MaxInt64

	for i := 0; i < n; i++ {
		g := nums[i]
		for j := i + 1; j < n; j++ {
			g = gcd(g, nums[j])
			if g == 1 {
				// j - i: how many flips to get first 1
				// n - 1: same case with there are 1s in the first place
				res = min(res, j-i+n-1)
				break
			}
		}
	}

	if res == math.MaxInt64 {
		return -1
	}

	return res
}
