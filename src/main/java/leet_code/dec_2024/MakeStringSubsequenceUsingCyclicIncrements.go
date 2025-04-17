package main

import "fmt"

func main() {

	fmt.Println(canMakeSubsequence("abc", "ad"))

}

func canMakeSubsequence(str1 string, str2 string) bool {
	index2 := 0
	for _, el := range str1 {
		// Direct match
		if index2 < len(str2) &&
			(byte(el) == str2[index2] || byte(el) == 'z' && str2[index2] == 'a' ||
				(byte(el)+1) == str2[index2]) {
			index2++
		}
	}

	return index2 == len(str2)
}
