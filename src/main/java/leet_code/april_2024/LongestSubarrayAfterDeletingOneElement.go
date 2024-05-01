package main

import "math"

func main() {

}

func longestSubarray(nums []int) int {
	i := 0
	j := 0
	k := 1
	res := math.MinInt

	zeroCounts := 0

	for j < len(nums) {
		if nums[j] == 0 {
			zeroCounts++

			if zeroCounts > k {

				for nums[i] != 0 {
					i++
				}
				i++
				zeroCounts--
			}
		}
		res = max(res, j-i+1)
		j++
	}

	return res - 1
}
