package main

import "fmt"

func main() {

	moveZeroes([]int{0, 1, 0, 3, 12})
	moveZeroes([]int{0})

}

func moveZeroes(nums []int) {
	left := 0

	for right := 0; right < len(nums); right++ {
		if nums[right] != 0 {
			nums[right], nums[left] = nums[left], nums[right]
			left++
		}
	}

	fmt.Println(nums)
}
