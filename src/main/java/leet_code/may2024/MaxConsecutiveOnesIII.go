package main

import (
	"fmt"
	"math"
)

func main() {

	//fmt.Println(longestOnes([]int{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2))
	fmt.Println(longestOnes([]int{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3))

}

func longestOnes3(nums []int, k int) int {
	l, r := 0, 0
	ans := 0

	for r < len(nums) {
		if nums[r] == 1 {
			r++
		} else {
			if k > 0 {
				r++
				k--
			} else {
				if nums[l] == 0 {
					k++
				}
				l++
			}
		}
		ans = max(ans, r-l)
	}

	return ans
}

func longestOnes(nums []int, k int) int { //Error: TLE

	left := 0
	right := 0
	res := math.MinInt
	for left < len(nums) {

		currOnes := 0
		currK := k
		right = left
		for right < len(nums) {
			if nums[right] == 1 {
				currOnes++
			}
			if nums[right] == 0 && currK <= 0 {
				fmt.Println(currK)
				break
			}
			if nums[right] == 0 && currK > 0 {
				currK--
				currOnes++
			}
			right++
		}
		//fmt.Printf("%v %v %v\n", left, right, currOnes)
		left++
		res = max(res, currOnes)
	}
	return res
}

func longestOnes2(nums []int, k int) int { //Error: TLE
	i := 0
	j := 0
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

	return res
}
