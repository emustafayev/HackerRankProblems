package main

import "fmt"

func main() {
	rotate([]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3)
	rotate2([]int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3)
}

func rotate(nums []int, k int) {
	newArr := make([]int, len(nums))

	for i := 0; i < len(nums); i++ {
		newArr[(i+k)%len(nums)] = nums[i]
	}

	for i := 0; i < len(nums); i++ {
		nums[i] = newArr[i]
	}
	fmt.Println(nums)
}

func rotate2(nums []int, k int) {

	n := len(nums)
	k %= n

	reverse(nums, 0, n-1)
	reverse(nums, 0, k-1)
	reverse(nums, k, n-1)
	fmt.Println(nums)
}

func reverse(nums []int, start, end int) {
	for start < end {
		nums[start], nums[end] = nums[end], nums[start]
		start++
		end--
	}
}
