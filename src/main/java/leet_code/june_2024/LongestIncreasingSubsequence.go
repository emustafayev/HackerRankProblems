package main

import (
	"fmt"
)

func main() {
	fmt.Println(lengthOfLIS([]int{0, 1, 0, 3, 2, 3}))

}

func lengthOfLIS0(nums []int) int {
	dp := make([]int, len(nums))
	res := 0
	for i := 0; i < len(nums); i++ {
		dp[i] = 1
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		res = max(dp[i], res)
	}
	return res
}

func lengthOfLIS(nums []int) int {
	n := len(nums)

	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, n+1) // Size n+1 to handle edge case where prevIndex is -1
		for j := range dp[i] {
			dp[i][j] = -1
		}
	}
	return solve(nums, 0, -1, dp)
}

func solve(nums []int, i, prevIndex int, dp [][]int) int {

	if len(nums) <= i {
		return 0
	}

	if dp[i][prevIndex+1] != -1 {
		return dp[i][prevIndex+1]
	}

	dontTake := solve(nums, i+1, prevIndex, dp)

	take := 0

	if prevIndex == -1 || nums[i] > nums[prevIndex] {
		take = 1 + solve(nums, i+1, i, dp)
	}
	dp[i][prevIndex+1] = max(dontTake, take)
	return dp[i][prevIndex+1]

}

//-----------------------------------------------

func lengthOfLIS2(nums []int) int {
	dp := []int{nums[0]}
	for i, n := range nums {
		if i == 0 {
			continue
		}
		if n > dp[len(dp)-1] {
			dp = append(dp, n)
		} else {
			binarySearchUpdate(dp, n)
		}
	}
	return len(dp)
}

func binarySearchUpdate(nums []int, n int) {
	l := 0
	r := len(nums) - 1
	mid := 0
	for l <= r {
		mid = (l + r) / 2
		if nums[mid] == n {
			return
		} else if n < nums[mid] {
			if mid > l && n > nums[mid-1] {
				break
			}
			r = mid - 1
		} else {
			l = mid + 1
		}
	}
	nums[mid] = n
	return
}
