package main

import (
	"fmt"
	"math"
	"sort"
)

func main() {

	fmt.Println(longestSquareStreak([]int{4, 3, 6, 16, 8, 2}))
}

func longestSquareStreak(nums []int) int {

	res := 0
	sort.Ints(nums)
	mp := make(map[int]int)
	for _, num := range nums {
		sqrt := int(math.Sqrt(float64(num)))
		if sqrt*sqrt == num {
			if val, ok := mp[sqrt]; ok {
				mp[num] = val + 1
				if res < val+1 {
					res = val + 1
				}
			} else {
				mp[num] = 1
			}
		} else {
			mp[num] = 1
		}
	}
	return res

}
