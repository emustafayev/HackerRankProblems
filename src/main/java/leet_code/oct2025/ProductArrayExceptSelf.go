package main

import "fmt"

func main() {

	fmt.Println(productExceptSelf([]int{1, 2, 3, 4}))
}

func productExceptSelf(nums []int) []int {

	prefix := make([]int, len(nums))
	suffix := make([]int, len(nums))

	prefProd := 1

	for i := 0; i < len(nums); i++ {
		prefProd *= nums[i]
		prefix[i] = prefProd
	}

	suffProd := 1
	for i := len(nums) - 1; i >= 0; i-- {
		suffProd = suffProd * nums[i]
		suffix[i] = suffProd
	}

	var res []int

	for i := 0; i < len(nums); i++ {
		var beforeP int

		if i == 0 {
			beforeP = 1
		} else {
			beforeP = prefix[i-1]
		}

		var beforS int
		if i == len(nums)-1 {
			beforS = 1
		} else {
			beforS = suffix[i+1]
		}
		res = append(res, beforeP*beforS)
	}
	return res
}
