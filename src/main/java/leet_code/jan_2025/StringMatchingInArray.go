package main

import (
	"sort"
	"strings"
)

func main() {

	words := []string{"aba", "xyz", "aa", "x", "bbb"}
	result := stringMatching(words)
	for _, v := range result {
		println(v)
	}

}

func stringMatching(words []string) []string {
	// Sort words by length
	sort.Slice(words, func(i, j int) bool {
		return len(words[i]) < len(words[j])
	})

	result := make(map[string]bool)

	// Compare each word with longer words
	for i := 0; i < len(words); i++ {
		for j := i + 1; j < len(words); j++ {
			if contains(words[j], words[i]) {
				result[words[i]] = true
				break
			}
		}
	}

	// Convert map keys to slice
	res := []string{}
	for k := range result {
		res = append(res, k)
	}
	return res
}

func contains(word, sub string) bool {
	return len(sub) <= len(word) && len(word) > 0 && len(sub) > 0 && strings.Contains(word, sub)
}
