package main

import (
	"fmt"
	"sort"
)

func main() {

	fmt.Println(sequentialDigits(100, 300))
	fmt.Println(sequentialDigits(1000, 13000))

}

func sequentialDigits(low int, high int) []int {
	//should generate sequences
	//starting from one

	//1,12,123,1234,12345,123456....
	//2,23,234,2345,23456 ...
	//3,34,345,3456,34567,345678
	//if bigger than high, stop generating sequences
	//if starting bigger than low, stop the loop

	result := make([]int, 0)

	for i := 1; i < 10; i++ {

		num := i

		for j := i + 1; j < 10; j++ {
			num = num*10 + j
			if num >= low && num <= high {
				result = append(result, num)
			}
		}

	}
	sort.Ints(result)
	return result
}
