package main

import (
	"fmt"
	"sort"
)

func main() {

	smallerNumbersThanCurrent([]int{8, 1, 2, 2, 3})
}

type Pair struct {
	Index        int
	Value        int
	SmallerCount int
}

func smallerNumbersThanCurrent(nums []int) []int {

	var pairs []Pair

	for i, n := range nums {
		pairs = append(pairs, Pair{
			Index: i,
			Value: n,
		})
	}

	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i].Value < pairs[j].Value
	})

	fmt.Println(pairs)

	smallerCount := 0
	prev := -1

	for _, pair := range pairs {

	}

	return nil
}
