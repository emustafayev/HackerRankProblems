package main

import (
	"fmt"
	"strings"
	"unicode"
)

func main() {

	fmt.Println(isPalindrome("A man, a plan, a canal: Panama"))
}

func isPalindrome(s string) bool {

	l, r := 0, len(s)-1

	for l < r {

		fmt.Println(l, r)

		for !isAlphanumeric(s[l]) && l < r {
			l++
		}
		for !isAlphanumeric(s[r]) && l < r {
			r--
		}
		if unicode.ToUpper(rune(s[l])) != unicode.ToUpper(rune(s[r])) {
			return false
		}
		l++
		r--
	}

	return true
}

func isAlphanumeric(ch uint8) bool {
	return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')
}

func isPalindrome2(s string) bool {
	s = strings.ToLower(s)
	var builder strings.Builder
	for i := 0; i < len(s); i++ {
		if s[i] >= 'a' && s[i] <= 'z' || s[i] >= '0' && s[i] <= '9' {
			builder.WriteByte(s[i])
		}
	}
	parsedstring := builder.String()
	fmt.Println(parsedstring)
	l, r := 0, len(parsedstring)-1
	for l <= r {
		if parsedstring[l] != parsedstring[r] {
			fmt.Println(parsedstring[l], parsedstring[r])
			return false
		}
		l++
		r--
	}
	return true
}
