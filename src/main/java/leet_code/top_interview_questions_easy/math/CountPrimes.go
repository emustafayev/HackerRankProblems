package main

import "fmt"

func main() {

	fmt.Println(countPrimes(10))
}

func countPrimes(n int) int {

	primeCheck := make([]bool, n)

	for i := 0; i < n; i++ {
		primeCheck[i] = true
	}

	for i := 2; i < n; i++ {
		if primeCheck[i] == true {
			for j := i * i; j < n; j += i {
				primeCheck[j] = false
			}
		}
	}
	fmt.Println(primeCheck)
	count := 0
	for i := 2; i < len(primeCheck); i++ {
		if primeCheck[i] == true {
			count++
		}
	}
	return count
}
