package main

import (
	"fmt"
	"strings"
)

func main() {

	reverseWords2("   hello      world")
	//reverseWords("  the sky is   blue     ")
	//reverseWords("the sky is blue")

}

func reverseWords(s string) string {
	var b strings.Builder
	words := strings.Fields(s)
	for i := len(words) - 1; i >= 0; i-- {
		b.WriteString(words[i])
		if i != 0 {
			b.WriteRune(' ')
		}
	}
	return b.String()
}

func reverseWords2(s string) string {
	left, right := 0, len(s)-1
	words := strings.Split(s, " ")

	fmt.Println(words)

	for left < right {
		words[left], words[right] = words[right], words[left]
		left++
		right--
	}

	return strings.Join(words, "")
}
