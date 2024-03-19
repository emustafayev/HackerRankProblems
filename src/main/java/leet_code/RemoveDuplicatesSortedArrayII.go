package main

import "fmt"

func main() {
	fmt.Println(removeDuplicates([]int{1, 1, 1, 2, 2, 3}))
	fmt.Println(removeDuplicates([]int{0, 0, 1, 1, 1, 1, 2, 3, 3}))
	fmt.Println(removeDuplicates([]int{1, 1, 1}))
}

func removeDuplicates(nums []int) int {
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

func removeDuplicates2(nums []int) int {
	if len(nums) < 2 {
		return len(nums)
	}
	w := 2
	for r := 2; r < len(nums); r++ {
		if nums[r] != nums[w-1] || nums[w-1] != nums[w-2] {
			nums[w] = nums[r]
			w++
		}
	}
	return w
}
