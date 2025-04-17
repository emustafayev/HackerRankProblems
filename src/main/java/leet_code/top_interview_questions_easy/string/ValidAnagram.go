package main

import "fmt"

func main() {

	fmt.Println(isAnagram("anagram", "nagaram"))
	fmt.Println(isAnagram("anfgram", "nagaram"))

}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}
	m := map[rune]int{}

	for _, ch := range s {
		m[ch]++
	}

	for _, ch := range t {
		m[ch]--
		if m[ch] < 0 {
			return false
		}
	}

	return true
}
