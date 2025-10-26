package main

import (
	"fmt"
	"math"
)

func main() {

	//fmt.Println(jump([]int{2, 3, 1, 1, 4}))
	//fmt.Println(jump([]int{2, 3, 0, 1, 4}))
	//fmt.Println(jump([]int{2, 1}))
	fmt.Println(jump([]int{1, 2, 1, 1, 1}))

}
func jump(nums []int) int {
	memo := make(map[int]int)
	return _jump(nums, 0, memo)
}

func _jump(nums []int, index int, memo map[int]int) int {
	if index >= len(nums)-1 {
		return 0 // No more steps needed
	}

	if val, exists := memo[index]; exists {
		return val
	}

	minStep := math.MaxInt
	for i := 1; i <= nums[index] && index+i < len(nums); i++ {
		newSteps := _jump(nums, index+i, memo)
		if newSteps != math.MaxInt {
			minStep = min(minStep, newSteps+1)
		}
	}

	memo[index] = minStep
	return minStep
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func jump2(nums []int) int {
	dp := make([]int, len(nums))
	for i := range dp {
		dp[i] = math.MaxInt32
	}
	dp[0] = 0
	for i := 0; i < len(nums); i++ {
		for j := i; j <= i+nums[i] && j < len(nums); j++ {
			dp[j] = Min(dp[j], 1+dp[i])
		}
	}
	return dp[len(nums)-1]
}

func Min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
