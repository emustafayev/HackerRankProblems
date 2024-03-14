package main

import "fmt"

func main() {

	fmt.Println(pivotInteger(8))
	fmt.Println(pivotInteger(1))
	fmt.Println(pivotInteger(4))
}

func pivotInteger(n int) int {

	if n == 1 {
		return 1
	}

	sum := 0
	for i := 1; i <= n; i++ {
		sum += i
	}

	var left int

	for i := 1; i < n; i++ {
		right := sum - left
		left += i
		if right == left {
			return i
		}
	}
	return -1

}
