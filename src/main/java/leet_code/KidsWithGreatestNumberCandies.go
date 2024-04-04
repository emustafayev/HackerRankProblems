package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(kidsWithCandies([]int{2, 3, 5, 1, 3}, 3))
}

func kidsWithCandies(candies []int, extraCandies int) []bool {

	max := math.MinInt

	for _, el := range candies {
		if el > max {
			max = el
		}
	}

	res := make([]bool, len(candies))

	for i := 0; i < len(candies); i++ {
		if candies[i]+extraCandies >= max {
			res[i] = true
		}
	}

	return res
}
