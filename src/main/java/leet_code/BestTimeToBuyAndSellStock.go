package main

import (
	"fmt"
	"math"
)

func main() {

	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4}))
	fmt.Println(maxProfit([]int{7, 6, 4, 3, 1}))
}

func maxProfit(prices []int) int {

	cheapest := math.MaxInt

	maxProf := math.MinInt

	res := 0

	for i := 0; i < len(prices); i++ {

		if maxProf < prices[i] {
			maxProf = prices[i]
		}

		if prices[i] < cheapest {
			cheapest = prices[i]
			maxProf = math.MinInt
		}
		res = max(res, maxProf-cheapest)
	}

	return res
}
