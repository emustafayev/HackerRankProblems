package main

import "fmt"

func main() {
	fmt.Println(numSubarrayProductLessThanK([]int{10, 5, 2, 6}, 100))
	fmt.Println(numSubarrayProductLessThanK([]int{10, 5, 2, 6}, 100))

}

func numSubarrayProductLessThanK(nums []int, k int) int {

	i := 0
	j := 1

	res := 0

	for i < len(nums) {
		j = i + 1
		product := nums[i]
		if product < k {
			res++
		}
		for j < len(nums) {
			product *= nums[j]
			j++

			if product < k {
				res++
			} else {
				break
			}
		}
		i++
	}

	return res
}
