package main

import (
	"fmt"
	"math"
)

func main() {

	fmt.Println(myAtoi("42"))
	fmt.Println(myAtoi("   -42"))
	fmt.Println(myAtoi("4193 with words"))

}

func myAtoi(s string) int {
	sign := 1

	index := 0
	for index < len(s) && s[index] == ' ' {
		index++
	}

	if index < len(s) && (s[index] == '-' || s[index] == '+') {
		if s[index] == '-' {
			sign = -1
		}
		index++
	}

	result := 0

	for index < len(s) && s[index] >= '0' && s[index] <= '9' {

		digit := int(s[index] - '0')

		if result > (math.MaxInt32-digit)/10 {
			if sign == 1 {
				return math.MaxInt32
			} else {
				return math.MinInt32
			}

		}
		result = result*10 + digit
		index++
	}

	return sign * result
}
