package main

import "fmt"

func main() {

	fmt.Println(maxDepth("(1+(2*3)+((8)/4))+1"))
	fmt.Println(maxDepth("(1)+((2))+(((3)))"))
}

func maxDepth(s string) int {
	up := 0
	res := 0
	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			up++
			res = maxD(res, up)
		} else if s[i] == ')' {
			up--
		}
	}
	return res
}

func maxD(a, b int) int {
	if a > b {
		return a
	}
	return b
}
