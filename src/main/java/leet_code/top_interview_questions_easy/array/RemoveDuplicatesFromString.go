package main

import "fmt"

func main() {

	fmt.Println(removeDuplicates([]int{0, 1, 1, 1, 1, 2, 2, 3, 3, 4}))
	fmt.Println(removeDuplicates([]int{1, 1, 2}))

}

func removeDuplicates(nums []int) int {
	k := 0

	for i := 1; i < len(nums); i++ {
		if nums[i] != nums[i-1] {
			k++
			nums[k] = nums[i]
		}
	}
	fmt.Println(nums)

	return k + 1
}
