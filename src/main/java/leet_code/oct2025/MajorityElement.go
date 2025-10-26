package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(majorityElement([]int{3, 2, 3}))
	fmt.Println(majorityElement([]int{2, 2, 1, 1, 1, 2, 2}))
}

func majorityElement(nums []int) int {
	m := map[int]int{}
	for i := 0; i < len(nums); i++ {
		m[nums[i]] = m[nums[i]] + 1
	}
	maxI := math.MinInt
	res := 0
	for k, v := range m {
		if v > maxI {
			maxI = v
			res = k
		}
	}
	return res
}
