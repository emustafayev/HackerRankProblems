package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(increasingTriplet([]int{1, 2, 3, 4, 5}))
	fmt.Println(increasingTriplet([]int{5, 4, 3, 2, 1}))
}

func increasingTriplet(nums []int) bool {
	min1, min2 := math.MaxInt, math.MaxInt
	for _, num := range nums {
		if num <= min1 {
			min1 = num
		} else if num <= min2 {
			min2 = num
		} else {
			return true
		}
	}
	return false
}
