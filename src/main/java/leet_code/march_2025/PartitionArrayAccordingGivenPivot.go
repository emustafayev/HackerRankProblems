package main

import "fmt"

func main() {

	nums := []int{2, 1, 5, 1, 6, 4}
	pivot := 5
	fmt.Println(pivotArray2(nums, pivot))
}

func pivotArray(nums []int, pivot int) []int {

	small := []int{}
	bigger := []int{}
	equals := []int{}

	for i := 0; i < len(nums); i++ {
		if nums[i] > pivot {
			bigger = append(bigger, nums[i])
		} else if nums[i] < pivot {
			small = append(small, nums[i])
		} else {
			equals = append(equals, nums[i])
		}
	}
	return append(append(small, equals...), bigger...)
}

func pivotArray2(nums []int, pivot int) []int {
	ans := make([]int, len(nums))
	l, r := 0, len(nums)-1

	for i := 0; i < len(nums); i++ {
		ans[i] = pivot
		if nums[i] < ans[i] {
			ans[l] = nums[i]
			l++
		}
	}

	for i := 0; i < len(nums); i++ {
		if nums[len(nums)-i-1] > pivot {
			ans[r] = nums[len(nums)-i-1]
			r--
		}
	}
	return ans
}
