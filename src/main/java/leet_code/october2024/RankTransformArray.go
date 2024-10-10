package main

import (
	"fmt"
	"sort"
)

func main() {
	arrayRankTransform2([]int{40, 11, 10, 20, 30, 7, 7, 22})
	//arrayRankTransform([]int{40, 10, 20, 30})
	//arrayRankTransform([]int{100, 100, 100, 20})
	//arrayRankTransform([]int{37, 12, 28, 9, 100, 56, 80, 5, 12})
}

type Pair struct {
	val int
	idx int
}

func arrayRankTransform(arr []int) []int {

	if len(arr) == 0 {
		return arr
	}

	var pairs []Pair
	for i, el := range arr {
		pairs = append(pairs, Pair{el, i})
	}
	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i].val < pairs[j].val
	})
	rank := 1
	prev := pairs[0].val
	pairs[0].val = rank

	for i := 1; i < len(pairs); i++ {
		if pairs[i].val != prev {
			rank++
		}
		prev = pairs[i].val
		pairs[i].val = rank

	}

	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i].idx < pairs[j].idx
	})

	var res []int

	for _, el := range pairs {
		res = append(res, el.val)
	}

	fmt.Println(res)
	return res

}

func arrayRankTransform2(arr []int) []int {
	b := make([]int, len(arr))
	copy(b, arr)
	sort.Ints(b)

	dic := make(map[int]int)

	for i, j := 0, 1; i < len(arr); i++ {
		if _, exists := dic[b[i]]; !exists {
			dic[b[i]] = j
			j++
		}
	}

	fmt.Println(dic)

	for i, a := range arr {
		arr[i] = dic[a]
	}

	return arr
}
