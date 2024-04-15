package main

import (
	"fmt"
	"strings"
)

func main() {
	fmt.Println(maximumOddBinaryNumber("010"))
	fmt.Println(maximumOddBinaryNumber("0101"))
}

func maximumOddBinaryNumber(s string) string {

	countOne := 0
	for _, char := range s {
		if char == '1' {
			countOne++
		}
	}
	var k int
	if countOne > 0 {
		k = 1
	}

	return strings.Repeat("1", countOne-1) + strings.Repeat("0", len(s)-countOne) + strings.Repeat("1", k)
}
