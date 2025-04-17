package main

import "fmt"

func main() {

	fmt.Println(countPrefixSuffixPairs([]string{"a", "aba", "ababa", "aa"}))

}

func countPrefixSuffixPairs(words []string) int {
	res := 0
	for i := 0; i < len(words); i++ {
		for j := i + 1; j < len(words); j++ {
			w1L := len(words[i])
			w2L := len(words[j])
			if w1L <= w2L && words[i] == words[j][:w1L] && words[i] == words[j][w2L-w1L:] {
				res++
			}
		}
	}
	return res
}
