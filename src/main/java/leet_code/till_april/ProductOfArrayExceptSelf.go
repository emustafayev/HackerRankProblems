package main

import "fmt"

func main() {

	fmt.Println(productExceptSelf([]int{1, 2, 3, 4}))
	fmt.Println(productExceptSelf([]int{-1, 1, 0, -3, 3}))

}

func productExceptSelf(nums []int) []int {

	prefix := make([]int, len(nums))
	suffix := make([]int, len(nums))

	prefProduct := 1

	for i := 0; i < len(nums); i++ {
		prefProduct = prefProduct * nums[i]
		prefix[i] = prefProduct
	}

	suffixProduct := 1

	for i := len(nums) - 1; i >= 0; i-- {
		suffixProduct = suffixProduct * nums[i]
		suffix[i] = suffixProduct
	}

	var res []int

	for i := 0; i < len(nums); i++ {

		var beforeP int
		if i == 0 {
			beforeP = 1
		} else {
			beforeP = prefix[i-1]
		}

		var afterP int
		if i == len(nums)-1 {
			afterP = 1
		} else {
			afterP = suffix[i+1]
		}
		res = append(res, beforeP*afterP)
	}

	return res
}

func productExceptSelf2(nums []int) []int {

	prefix := make([]int, len(nums))
	postfix := make([]int, len(nums))

	rev := len(nums) - 1
	for i, v := range nums {
		if i == 0 {
			prefix[i] = v
			postfix[rev] = nums[rev]
			rev--
		} else {
			prefix[i] = v * prefix[i-1]
			postfix[rev] = nums[rev] * postfix[rev+1]
			rev--
		}
	}

	answer := make([]int, len(nums))
	for i := range prefix {
		if i == 0 {
			answer[i] = 1 * postfix[i+1]
			continue
		}
		if i == len(nums)-1 {
			answer[i] = prefix[i-1] * 1
			continue
		}
		answer[i] = prefix[i-1] * postfix[i+1]
	}

	return answer
}
