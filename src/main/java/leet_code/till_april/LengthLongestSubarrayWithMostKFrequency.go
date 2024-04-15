package main

import (
	"fmt"
)

func main() {
	fmt.Println(maxSubarrayLength([]int{1, 2, 3, 1, 2, 3, 1, 2}, 2))
	//fmt.Println(maxSubarrayLength([]int{1, 2, 1, 2, 1, 2, 1, 2}, 1))
	//fmt.Println(maxSubarrayLength([]int{5, 5, 5, 5, 5, 5, 5}, 4))
	fmt.Println(maxSubarrayLength([]int{8, 8}, 1))
	//fmt.Println(maxSubarrayLength([]int{8, 6}, 1))
}

func maxSubarrayLength(nums []int, k int) int {
	i := 0
	j := 0
	mp := make(map[int]int)
	ans := 1

	for i < len(nums) {
		mp[nums[i]]++
		for mp[nums[i]] > k {
			mp[nums[j]]--
			j++
		}
		if i-j+1 > ans {
			ans = i - j + 1
		}
		i++
	}
	return ans
}
