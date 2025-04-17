package main

import "fmt"

func main() {
	fmt.Println(checkPowersOfThree(12))
	fmt.Println(checkPowersOfThree(91))
	fmt.Println(checkPowersOfThree(27))
	fmt.Println(checkPowersOfThree(21))
}

func checkPowersOfThree(n int) bool {
	for n > 0 {
		if n%3 == 2 {
			return false
		}
		n /= 3
	}
	return true
}
