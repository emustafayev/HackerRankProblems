package main

import "fmt"

func main() {

	fmt.Println(makeGood("hHcOzoC"))
	fmt.Println(makeGood("abBAcC"))
}

func makeGood(s string) string {
	var stack []int
	for i := 0; i < len(s); i++ {
		var lastEl int
		if len(stack) > 0 {
			lastEl = stack[len(stack)-1]
			if (lastEl == int(s[i])+32) || (lastEl == int(s[i])-32) {
				stack = stack[0 : len(stack)-1]
			} else {
				stack = append(stack, int(s[i]))
			}
		} else {
			stack = append(stack, int(s[i]))
		}
	}
	res := ""
	for i := 0; i < len(stack); i++ {
		res += string(rune(stack[i]))
	}
	return res
}

func makeGood2(s string) string {
	bytes := make([]byte, 0)
	for i, _ := range s {
		n := len(bytes)
		if n > 0 && (bytes[n-1] == s[i]-'a'+'A' || bytes[n-1] == s[i]-'A'+'a') {
			bytes = bytes[:n-1]
		} else {
			bytes = append(bytes, s[i])
		}
	}
	return string(bytes)
}
