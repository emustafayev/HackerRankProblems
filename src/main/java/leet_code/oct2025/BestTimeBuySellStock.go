package main

import (
	"fmt"
	"math"
	"runtime/debug"
)

func main() {
	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4}))
	fmt.Println(maxProfit([]int{7, 6, 4, 3, 1}))
}

func maxProfit(prices []int) int {
	cheapest := math.MaxInt
	maxPrft := math.MinInt
	for i := 0; i < len(prices); i++ {
		if cheapest > prices[i] {
			cheapest = prices[i]
		}
		if prices[i]-cheapest > maxPrft {
			maxPrft = prices[i] - cheapest
		}
	}
	return maxPrft
}

func init() {
	debug.SetMemoryLimit(1)
}
