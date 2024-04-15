package main

import (
	"fmt"
	"math"
)

//You are given an integer array nums and a positive integer k.
//
//Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.
//
//A subarray is a contiguous sequence of elements within an array.
//
//

func main() {
	fmt.Println(countSubarrays([]int{1, 3, 2, 3, 3}, 2))
}

func countSubarrays(nums []int, k int) int64 {

	i := 0
	j := 0

	var res int64
	mp := make(map[int]int)

	maxEl := math.MinInt
	for _, el := range nums {
		if el > maxEl {
			maxEl = el
		}
	}

	for i < len(nums) {
		mp[nums[i]]++
		fmt.Printf("%v - %v\n", j, i)

		if mp[maxEl] >= k {
			res++
		}
		for mp[maxEl] >= k {
			mp[nums[j]]--
			j++
		}
		i++
	}

	return res
}

func countSubarrays2(nums []int, k int) int64 {
	maxValue := 0
	var maxValueIds []int
	var ans int64

	for i, x := range nums {
		if x > maxValue {
			maxValue, ans, maxValueIds = x, 0, []int{}
		}

		if x == maxValue {
			maxValueIds = append(maxValueIds, i)
		}

		if len(maxValueIds) >= k {
			ans += int64(maxValueIds[len(maxValueIds)-k]) + 1
		}
	}
	return ans
}
