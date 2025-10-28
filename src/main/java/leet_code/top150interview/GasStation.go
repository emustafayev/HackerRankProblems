package main

import "fmt"

func main() {

	fmt.Println(canCompleteCircuit([]int{1, 2, 3, 4, 5}, []int{3, 4, 5, 1, 2}))
	fmt.Println(canCompleteCircuit([]int{2, 3, 4}, []int{3, 4, 3}))

}

func canCompleteCircuit(gas []int, cost []int) int {

	totalGas := 0
	totalCost := 0

	for i := 0; i < len(gas); i++ {
		totalGas += gas[i]
		totalCost += cost[i]
	}
	if totalGas < totalCost {
		return -1
	}
	depo := 0
	start := 0
	for i := 0; i < len(cost); i++ {
		depo += gas[i] - cost[i]
		if depo < 0 {
			start = i + 1
			depo = 0
		}
	}

	return start

}
