package main

import (
	"fmt"
	"sort"
)

func main() {

	fmt.Println(combinationSum([]int{2, 3, 6, 7}, 7))

}

func combinationSum(candidates []int, target int) [][]int {

	sort.Slice(candidates, func(i, j int) bool {
		return candidates[i] < candidates[j]
	})

	results := make([][]int, 0)
	combine(&results, []int{}, candidates, target, 0)
	return results
}

func combine(results *[][]int, combination, candidates []int, target, index int) {
	if target == 0 {
		validComb := make([]int, len(combination))
		copy(validComb, combination)
		*results = append(*results, validComb)
		return
	} else if target < 0 {
		return
	} else {
		for i := index + 1; i < len(candidates); i++ {
			combine(results, append(combination, candidates[i]), candidates, target-candidates[i], i)
		}
	}
}
