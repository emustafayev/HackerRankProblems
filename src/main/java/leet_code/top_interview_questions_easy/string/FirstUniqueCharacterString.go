package main

import (
	"fmt"
	"math"
)

func main() {

	fmt.Println(firstUniqChar("leetcode"))
	fmt.Println(firstUniqChar("loveleetcode"))
}

func firstUniqChar(s string) int {

	m := map[rune]int{}

	for i, ch := range s {

		if _, ok := m[ch]; ok {
			m[ch] = -1
		} else {
			m[ch] = i
		}
	}
	res := math.MaxInt

	for _, v := range m {
		if v != -1 {
			if v < res {
				res = v
			}
		}
	}

	if res == math.MaxInt {
		return -1
	}

	return res
}

func firstUniqChar2(s string) int {
	seen := make([]int, 26)

	for i := 0; i < len(s); i++ {
		seen[s[i]-'a']++
	}

	for i := 0; i < len(s); i++ {
		if seen[s[i]-'a'] == 1 {
			return i
		}
	}

	return -1
}
