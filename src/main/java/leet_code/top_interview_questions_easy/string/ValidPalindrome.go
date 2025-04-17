package main

import (
	"fmt"
	"unicode"
)

func main() {
	fmt.Println(isPalindrome("A man, a plan, a canal: Panama"))
}

func isPalindrome(s string) bool {
	l, r := 0, len(s)-1
	for l < r {
		for !isAlphanumeric(rune(s[l])) && l < r {
			l++
		}
		for !isAlphanumeric(rune(s[r])) && l < r {
			r--
		}
		if unicode.ToLower(rune(s[l])) != unicode.ToLower(rune(s[r])) {
			return false
		}
		l++
		r--
	}
	return true
}

func isAlphanumeric(u rune) bool {
	return (u >= 'a' && u <= 'z') || (u >= 'A' && u <= 'Z') || (u >= '0' && u <= '9')
}
