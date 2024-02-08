package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Println(evalRPN([]string{"4", "13", "5", "/", "+"}))
	//fmt.Println(evalRPN([]string{"2", "1", "+", "3", "*"}))
}

func evalRPN(tokens []string) int {
	var stack []int

	for _, el := range tokens {

		//fmt.Println(stack)

		switch el {
		case "+":
			res := stack[len(stack)-2] + stack[len(stack)-1]
			stack = stack[:len(stack)-2]
			stack = append(stack, res)
		case "*":
			res := stack[len(stack)-2] * stack[len(stack)-1]
			stack = stack[:len(stack)-2]
			stack = append(stack, res)
		case "/":
			res := stack[len(stack)-2] / stack[len(stack)-1]
			stack = stack[:len(stack)-2]
			stack = append(stack, res)
		case "-":
			res := stack[len(stack)-2] - stack[len(stack)-1]
			stack = stack[:len(stack)-2]
			stack = append(stack, res)
		default:
			i, _ := strconv.Atoi(el)
			stack = append(stack, i)
		}

	}

	return stack[0]

}
