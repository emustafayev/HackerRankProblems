package main

import "fmt"

func main() {

	fmt.Println(firstUniqChar("aabb"))
}

func firstUniqChar(s string) int {
	var count [26]int

	for i := 0; i < len(s); i++ {
		count[s[i]-'a']++
	}
	for i := 0; i < len(s); i++ {
		if count[s[i]-'a'] == 1 {
			return i
		}
	}
	return -1
}
