package main

import "fmt"

func main() {
	fmt.Println(removeStars("leet**cod*e"))
}

func removeStars(s string) string {
	var stack []int32

	for _, ch := range s {
		if ch != '*' {
			stack = append(stack, ch)
		} else {
			if len(stack) > 0 {
				stack = stack[:len(stack)-1]
			}
		}
		//printStack(stack)
	}

	return string(stack)
}

func printStack(stack []int32) {
	for i := 0; i < len(stack); i++ {
		fmt.Printf("%v ", string(stack[i]))
	}
	fmt.Println()
}
