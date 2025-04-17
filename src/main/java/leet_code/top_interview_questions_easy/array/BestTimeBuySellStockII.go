package main

import "fmt"

func main() {

	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4}))
	fmt.Println(maxProfit([]int{1, 2, 3, 4, 5}))
	fmt.Println(maxProfit([]int{7, 6, 4, 3, 1}))

}

func maxProfit(prices []int) int {
	profit := 0
	for i := 1; i < len(prices); i++ {

		if prices[i] > prices[i-1] {
			profit += prices[i] - prices[i-1]
		}
	}
	return profit
}
