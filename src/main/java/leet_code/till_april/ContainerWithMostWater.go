package main

import (
	"fmt"
	"math"
)

func main() {
	height := []int{1, 8, 6, 2, 5, 4, 8, 3, 7}
	fmt.Println(maxArea(height))
}

func maxArea(height []int) int {
	l := 0
	r := len(height) - 1
	maxW := math.MinInt
	for l < r {
		maxW = maxWater(maxW, (r-l)*minWater(height[l], height[r]))
		if height[l] > height[r] {
			r--
		} else {
			l++
		}
	}
	return maxW
}

func minWater(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func maxWater(a, b int) int {
	if a > b {
		return a
	}
	return b
}
