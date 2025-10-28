package main

import "fmt"

func main() {
	fmt.Println(removeDuplicates2([]int{0, 1, 1, 1, 2, 2, 3, 3, 4}))
}

func removeDuplicates2(nums []int) int {
	var j = 1

	for i := 1; i < len(nums); i++ {
		if j == 1 || nums[i] != nums[j-2] {
			nums[j] = nums[i]
			j++
		}
		fmt.Println(nums)
	}
	return j
}
