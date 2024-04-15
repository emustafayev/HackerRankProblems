package main

import "fmt"

func main() {
	moveZeroes([]int{0, 1, 0, 3, 12})
}

func moveZeroes(nums []int) {

	left := 0
	zCount := 0

	for _, el := range nums {
		if el == 0 {
			zCount++
		}
	}
	for i := 0; i < len(nums); i++ {
		if nums[i] != 0 {
			fmt.Println(nums[i])
			nums[left] = nums[i]
			left++
		}
	}
	for i := len(nums) - zCount; i < len(nums); i++ {
		nums[left] = 0
		left++
	}
}

func moveZeros2(nums []int) {
	l := 0
	for i, n := range nums {
		if n != 0 {
			nums[l], nums[i] = nums[i], nums[l]
			l++
		}
	}
}
