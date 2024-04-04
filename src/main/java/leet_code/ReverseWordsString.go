package main

import "fmt"

func main() {
	fmt.Println(reverseWords("  hello world "))

}

func reverseWords(s string) string {

	reversedStrings := []string{}

	for i := 0; i < len(s); i++ {

		running := i

		for running < len(s) && s[running] != ' ' {
			running++
		}

		if i != running {
			reversedStrings = append(reversedStrings, s[i:running])
		}
		i = running
	}

	res := reversedStrings[len(reversedStrings)-1]

	for i := len(reversedStrings) - 2; i >= 0; i-- {
		res += " "
		res += reversedStrings[i]
	}

	return res

}
