package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(maxOperations([]int{1, 2, 3, 4}, 5))
	fmt.Println(maxOperations([]int{3, 1, 3, 4, 3}, 6))
}

func maxOperations(nums []int, k int) int {
	sort.Ints(nums)
	l := 0
	r := len(nums) - 1
	res := 0
	for l < r {
		numberOne := nums[l]
		numberTwo := nums[r]
		if numberTwo+numberOne > k {
			r--
		} else if (numberTwo + numberOne) < k {
			l++
		} else {
			res++
			l++
			r--
		}
	}
	return res
}
