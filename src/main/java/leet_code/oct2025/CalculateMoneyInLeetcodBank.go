package main

import "fmt"

func main() {

	fmt.Println(totalMoney(4))

}

func totalMoney(n int) int {
	sum := 0
	for i := 0; i < n; i++ {
		sum += 1 + i%7 + i/7
	}
	return sum
}
