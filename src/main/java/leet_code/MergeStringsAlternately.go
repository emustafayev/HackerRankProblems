package main

import (
	"fmt"
)

func main() {
	fmt.Println(mergeAlternately("abc", "pqr"))
	fmt.Println(mergeAlternately("ab", "pqrs"))
	fmt.Println(mergeAlternately("abc", "pqr"))
}

func mergeAlternately(word1 string, word2 string) string {
	i := 0
	j := 0

	ans := ""

	for i < len(word1) || j < len(word2) {
		if i < len(word1) {
			ans = ans + string(word1[i])
		}
		if j < len(word2) {
			ans = ans + string(word2[j])
		}
		i++
		j++
	}
	return ans
}
