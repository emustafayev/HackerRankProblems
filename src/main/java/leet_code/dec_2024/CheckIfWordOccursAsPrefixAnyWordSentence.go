package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Print(isPrefixOfWord("i love eating burger", "burg"))
}

func isPrefixOfWord(sentence string, searchWord string) int {

	for i, word := range strings.Split(sentence, " ") {
		if strings.HasPrefix(word, searchWord) {
			return i + 1
		}
	}

	return -1
}
