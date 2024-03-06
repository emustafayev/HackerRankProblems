package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(findLeastNumOfUniqueInts([]int{4, 3, 1, 1, 3, 3, 2}, 3))
}

//Example 1:
//
//Input: arr = [5,5,4], k = 1
//Output: 1
//Explanation: Remove the single 4, only 5 is left.
//Example 2:
//Input: arr = [4,3,1,1,3,3,2], k = 3
//Output: 2
//Explanation: Remove 4, 2 and either one of the two 1s or three 3s. 1 and 3 will be left.

func findLeastNumOfUniqueInts(arr []int, k int) int {
	if len(arr) <= k+1 {
		return len(arr) - k
	}
	m := make(map[int]int)
	for _, el := range arr {
		if elCount, exists := m[el]; exists {
			m[el] = elCount + 1
		} else {
			m[el] = 1
		}
	}

	pairs := []int{}

	for _, v := range m {
		pairs = append(pairs, v)
	}

	sort.Slice(pairs, func(i, j int) bool {
		return pairs[i] < pairs[j]
	})

	res := 0
	for _, el := range pairs {
		k = k - el
		if k < 0 {
			res++
		}
	}
	return res
}
