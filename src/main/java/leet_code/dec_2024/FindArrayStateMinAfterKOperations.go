package main

import "slices"

func main() {

}

func getFinalState(nums []int, k int, multiplier int) []int {

	for i := 0; i < k; i++ {
		minInd := slices.Index(nums, slices.Min(nums))

		nums[minInd] *= multiplier

	}

	return nums
}
