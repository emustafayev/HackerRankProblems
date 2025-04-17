package main

import (
	"fmt"
	"slices"
)

func main() {

	//wordSubsets([]string{"amazon", "apple", "facebook", "google", "leetcode"},
	//	[]string{"e", "o"})

	fmt.Println(wordSubsets([]string{"amazon", "apple", "facebook", "google", "leetcode"},
		[]string{"e", "oo", "o"}))
}

func wordSubsets(words1 []string, words2 []string) []string {

	maxFreq := make(map[rune]int)
	for _, word := range words2 {
		temp := make(map[rune]int)

		for _, letter := range word {
			temp[letter]++
		}

		for letter, count := range temp {
			if maxFreq[letter] < count {
				maxFreq[letter] = count
			}

		}
	}
	result := make([]string, 0)
	for _, word := range words1 {
		wMaxFreq := make(map[rune]int)
		for _, letter := range word {
			wMaxFreq[letter]++
		}
		add := true
		for k, v := range maxFreq {
			if uniVal, found := wMaxFreq[k]; !found || uniVal < v {
				add = false
				break
			}
		}
		if add {
			result = append(result, word)
		}
	}
	return result
}

type cFreq [26]int

func wordSubsets2(candidates, targets []string) (subs []string) {
	target := reduce(targets)

	for i := range candidates {
		if isSubset(&candidates[i], &target) {
			subs = append(subs, candidates[i])
		}
	}

	return
}

func reduce(targets []string) (word string) {
	cmap := cFreq{}

	for i := range targets {
		tmap := cFreq{}
		for _, c := range targets[i] {
			c -= 'a'
			tmap[c]++
			cmap[c] = max(cmap[c], tmap[c])
		}
	}

	words := []byte{}
	for c, count := range cmap {
		words = append(words, slices.Repeat([]byte{byte(c) + 'a'}, count)...)
	}

	return string(words)
}

func isSubset(candidate, target *string) bool {
	cmap := cFreq{}

	for _, c := range *candidate {
		cmap[c-'a']++
	}

	for _, c := range *target {
		c -= 'a'
		if cmap[c] == 0 {
			return false
		}

		cmap[c]--
	}

	return true
}
