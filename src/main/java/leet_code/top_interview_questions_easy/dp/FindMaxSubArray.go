package main

import "math"

func main() {

}

func maxSubArray(nums []int) int {

	return solve(0, nums, false)

}

func solve(i int, nums []int, mustPick bool) int {

	if i >= len(nums) {

		if mustPick {
			return 0
		} else {
			return math.MinInt
		}

	}

	if mustPick {
		return max(0, nums[i]+solve(i+1, nums, true))
	} else {
		return max(solve(i+1, nums, false), nums[i]+solve(i+1, nums, true))
	}
}
