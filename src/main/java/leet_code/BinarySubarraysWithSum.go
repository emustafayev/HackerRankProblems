package main

import "fmt"

func main() {

	fmt.Println(numSubarraysWithSum([]int{1, 0, 1, 0, 1}, 2))
}

func numSubarraysWithSum(nums []int, goal int) int {
	m := make(map[int]int)
	res := 0
	prefixSum := 0

	for _, num := range nums {
		prefixSum += num
		if prefixSum == goal {
			res++
		}
		if count, found := m[prefixSum-goal]; found {
			res += count
		}

		if count, found := m[prefixSum]; found {
			m[prefixSum] = count + 1
		} else {
			m[prefixSum] = 1
		}
	}

	return res
}
