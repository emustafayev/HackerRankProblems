package main

import (
	"fmt"
	"math"
)

func main() {

	fmt.Println(findMaxConsecutiveOnes([]int{1, 1, 0, 1, 1, 1}))
}

func findMaxConsecutiveOnes(nums []int) int {
	maxCons := math.MinInt

	current := 0

	for i := 0; i < len(nums); i++ {
		if nums[i] == 1 {
			current++
			if maxCons < current {
				maxCons = current
			}
		} else {
			current = 0
		}
	}

	if maxCons == math.MinInt {
		return 0
	}

	return maxCons
}
