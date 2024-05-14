package main

import (
	"fmt"
	"sort"
)

func main() {

	fmt.Println(kthSmallestPrimeFraction([]int{1, 2, 3, 5}, 3))
	//fmt.Println(kthSmallestPrimeFraction([]int{1, 7}, 1))
	fmt.Println(kthSmallestPrimeFraction([]int{1, 29, 47}, 1))

}

func kthSmallestPrimeFraction(arr []int, k int) []int {

	if len(arr) == 2 {
		return arr
	}

	type pairs struct {
		Pair     []int
		Fraction float64
	}
	var kthSmallestPair []pairs

	for i := 0; i < len(arr); i++ {
		for j := i + 1; j < len(arr); j++ {
			kthSmallestPair = append(kthSmallestPair, pairs{Pair: []int{arr[i], arr[j]}, Fraction: float64(arr[i]) / float64(arr[j])})
		}
	}
	sort.Slice(kthSmallestPair, func(i, j int) bool {
		return kthSmallestPair[i].Fraction < kthSmallestPair[j].Fraction
	})

	return kthSmallestPair[k-1].Pair
}
