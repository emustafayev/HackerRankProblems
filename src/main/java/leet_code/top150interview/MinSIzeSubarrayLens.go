package main

import (
	"fmt"
	"math"
)

func main() {

	fmt.Println(minSubArrayLen(7, []int{2, 3, 1, 2, 4, 3}))

}

func minSubArrayLen(target int, nums []int) int {

	total := 0
	start := 0
	minSize := math.MaxInt

	for i := 0; i < len(nums); i++ {
		total += nums[i]

		for total >= target {
			minSize = minFound(minSize, i-start+1)
			total -= nums[start]
			start++
		}

	}

	if minSize == math.MaxInt {
		return 0
	}

	return minSize

}

func minFound(a int, b int) int {
	if a > b {
		return b
	} else {
		return a
	}
}
