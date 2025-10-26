package main

import "fmt"

func main() {

	fmt.Println(removeDuplicates([]int{0, 0, 1, 1, 1, 1, 2, 3, 3}))
}

// each unique element appears at most twice.

//Input: nums = [0,0,1,1,1,1,2,3,3]

//Output: 7, nums = [0,0,1,1,2,3,3,_,_]

func removeDuplicates(nums []int) int {
	current, windowSum := 1, 0

	for i := 1; i < len(nums); i++ {

		if nums[current-1] != nums[i] {
			windowSum = 0
			nums[current] = nums[i]
			current++
		} else {
			windowSum++
			if windowSum < 2 {
				nums[current] = nums[i]
				current++
			}
		}
	}
	return current
}

func removeDuplicates2(nums []int) int {
	if len(nums) < 2 {
		return len(nums)
	}
	indx := 2
	for i := 2; i < len(nums); i++ {
		if nums[indx-2] != nums[i] {
			nums[indx] = nums[i]
			indx++
		}
	}
	return indx
}
