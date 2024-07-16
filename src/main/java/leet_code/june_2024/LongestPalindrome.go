package main

import "fmt"

func main() {

	fmt.Println(longestPalindrome("abcccdd"))
}

func longestPalindrome(s string) int {

	n := len(s)
	pairs := 0
	m := make(map[rune]int)

	for _, ch := range s {
		m[ch]++
		if m[ch]%2 == 0 {
			pairs++
		}
	}
	if pairs*2 == n {
		return n
	}
	return pairs*2 + 1
}
