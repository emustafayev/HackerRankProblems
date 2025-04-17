package main

import (
	"fmt"
)

func main() {
	fmt.Println(addSpaces("LeetcodeHelpsMeLearn", []int{8, 13, 15}))
	fmt.Println(addSpaces("icodeinpython", []int{1, 5, 7, 9}))
	fmt.Println(addSpaces("spacing", []int{0, 1, 2, 3, 4, 5, 6}))
}

func addSpaces(s string, spaces []int) string {

	arrStr := make([]byte, 0, len(s)+len(spaces))

	for j, i := 0, 0; i < len(s); i++ {

		if j < len(spaces) && spaces[j] == i {
			arrStr = append(arrStr, ' ')
			j++
		}
		arrStr = append(arrStr, s[i])
	}
	return string(arrStr)
}
