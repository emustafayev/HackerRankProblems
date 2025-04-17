package main

import (
	"fmt"
)

func main() {

	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))

}

func twoSum(nums []int, target int) []int {

	for i := 0; i < len(nums); i++ {

		for j := i + 1; j < len(nums); j++ {
			if nums[i]+nums[j] == target {
				return []int{i, j}
			}
		}

	}
	return []int{}

}

func twoSum2(nums []int, target int) []int {

	m := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		currentNeed := target - nums[i]

		if _, ok := m[currentNeed]; ok {
			return []int{m[currentNeed], i}
		}
		m[nums[i]] = i
	}
	return []int{}

}
