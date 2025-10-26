package main

import (
	"fmt"
)

func main() {

	fmt.Println(maxProfit2([]int{7, 1, 5, 3, 6, 4}))
}

func maxProfit2(prices []int) int {
	profit := 0
	for i := 1; i < len(prices); i++ {
		if prices[i] > prices[i-1] {
			profit += prices[i] - prices[i-1]
		}
	}
	return profit
}
