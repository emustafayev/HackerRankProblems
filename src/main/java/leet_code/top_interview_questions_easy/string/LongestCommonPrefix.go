package main

import "fmt"

func main() {
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", "flight"}))
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", "floght"}))
}

func longestCommonPrefix(strs []string) string {

	if len(strs) == 0 {
		return ""
	}

	prefix := strs[0]
	for i := 1; i < len(strs); i++ {
		currentWord := strs[i]
		j := 0
		for j < len(prefix) && j < len(currentWord) && prefix[j] == currentWord[j] {
			j++
		}
		if j == 0 {
			return ""
		}
		prefix = prefix[:j]
	}
	return prefix
}
