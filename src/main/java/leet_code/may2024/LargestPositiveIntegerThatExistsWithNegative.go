package main

import (
	"math"
	"slices"
)

func main() {

}

func findMaxK(nums []int) int {
	slices.Sort(nums)
	l, r := 0, len(nums)-1
	res := math.MinInt
	var abs func(a int) int

	abs = func(a int) int {
		if a > 0 {
			return a
		}
		return -1 * a
	}

	for l < r {
		pairSum := nums[l] + nums[r]
		if pairSum == 0 {
			res = max(res, abs(nums[l]))
			l++
			r--
		} else if pairSum > 0 {
			r--
		} else {
			l++
		}
	}
	if res == math.MinInt {
		return -1
	}
	return res
}
