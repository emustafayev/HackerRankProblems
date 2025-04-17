package main

func main() {

}

func maxProfit(prices []int) int {
	profit := 0
	buyStock := prices[0]
	for i := 1; i < len(prices); i++ {
		if buyStock > prices[i] {
			buyStock = prices[i]
		}
		profit = max(profit, prices[i]-buyStock)
	}
	return profit
}
