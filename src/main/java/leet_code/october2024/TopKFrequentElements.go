package main

import (
	"fmt"
	"sort"
)

type pair struct {
	key   int
	value int
}

func main() {

	fmt.Println(topKFrequent([]int{1, 1, 1, 2, 2, 3}, 2))
	fmt.Println(topKFrequent([]int{1}, 1))

}

func topKFrequent(nums []int, k int) []int {

	mp := make(map[int]int)
	//Count occurrences
	for _, el := range nums {
		mp[el]++
	}

	pairs := make([]pair, 0)

	//add to pairs
	for k, v := range mp {
		pairs = append(pairs, pair{k, v})
	}

	//sort from most occurrences to less
	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i].value > pairs[j].value
	})

	res := make([]int, 0)

	//Take first k elements
	for i := 0; i < k; i++ {
		res = append(res, pairs[i].key)
	}

	return res
}
