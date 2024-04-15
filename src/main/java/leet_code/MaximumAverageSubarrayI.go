package main

import (
	"fmt"
)

func main() {
	fmt.Println(findMaxAverage([]int{1, 12, -5, -6, 50, 3}, 3))
}

func findMaxAverage(nums []int, k int) float64 {

	maxVal := 0
	for i := 0; i < k; i++ {
		maxVal += nums[i]
	}

	tempVal := maxVal

	for i := k; i < len(nums); i++ {
		tempVal += nums[i] - nums[i-k]
		if tempVal > maxVal {
			maxVal = tempVal
		}
	}

	return float64(maxVal) / float64(k)

}
