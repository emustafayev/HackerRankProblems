package main

import (
	"fmt"
)

func main() {

	fmt.Println(findErrorNums([]int{1, 1}))
	fmt.Println(findErrorNums([]int{1, 2, 2, 4}))
	fmt.Println(findErrorNums([]int{3, 2, 3, 4, 6, 5}))
	fmt.Println(findErrorNums([]int{1, 5, 3, 2, 2, 7, 6, 4, 8, 9}))
}

func findErrorNums(nums []int) []int {
	seen := make([]int, len(nums))
	var res []int
	for _, n := range nums { //take all the existed numbers and found duplication
		if seen[n-1] == 0 {
			seen[n-1] = n
		} else {
			res = append(res, n)
		}
	}
	for i, n := range seen { // add index of not seen element index
		if n == 0 {
			res = append(res, i+1)
		}
	}
	return res
}
