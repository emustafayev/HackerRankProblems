package main

import "fmt"

func main() {

	fmt.Println(longestMonotonicSubarray([]int{5, 5, 2, 3, 4, 1}))
	fmt.Println(longestMonotonicSubarray([]int{1, 4, 3, 3, 2}))
	fmt.Println(longestMonotonicSubarray([]int{3, 3, 3, 3, 3, 3, 3, 3}))
	fmt.Println(longestMonotonicSubarray([]int{3}))
}

func longestMonotonicSubarray(nums []int) int {

	incMax := 0
	decMax := 0
	for i := 0; i < len(nums); i++ {
		inc := 1
		dec := 1
		j := i + 1
		for j < len(nums) && nums[j] > nums[j-1] {
			inc++
			j++
		}
		j = i + 1
		for j < len(nums) && nums[j] < nums[j-1] {
			dec++
			j++
		}
		incMax = max(incMax, inc)
		decMax = max(decMax, dec)
	}

	if incMax > decMax {
		return incMax
	} else {
		return decMax
	}
}
