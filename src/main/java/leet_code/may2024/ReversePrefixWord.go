package main

import (
	"fmt"
	"strings"
)

func main() {

	fmt.Println(reversePrefix("abcdefd", 'd'))
	fmt.Println(reversePrefix("abcdefd", 'l'))
}

func reversePrefix(word string, ch byte) string {

	reversed := ""
	found := -1
	for i, el := range word {
		if byte(el) == ch {
			reversed = string(el) + reversed
			found = i
			break
		}
		reversed = string(el) + reversed
	}

	if found != -1 {
		return reversed + word[found+1:]
	}
	return word
}

func reversePrefix2(word string, ch byte) string {
	length := strings.Index(word, string(ch)) + 1

	wordBite := []byte(word)

	for i := 0; i < length/2; i++ {
		wordBite[i], wordBite[length-i-1] = word[length-i-1], word[i]
	}

	return string(wordBite)
}

func reversePrefix3(word string, ch byte) string {
	var natija string
	for i := 0; i < len(word); i++ {
		if word[i] == ch {
			ch_index := i
			for i >= 0 {
				natija += string(word[i])
				i--
			}
			return natija + word[ch_index+1:]
		}
	}
	return word
}
