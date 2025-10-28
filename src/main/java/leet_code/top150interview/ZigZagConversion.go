package main

import "fmt"

func main() {

	fmt.Println(convert("PAYPALISHIRING", 3))
}

// "PAY P ALI S HIR I NG"

//P   A   H   N
//A P L S I I G
//Y   I   R

//----

//P  A
//A P
//Y

func convert(s string, numRows int) string {

	if numRows == 1 || numRows >= len(s) {
		return s
	}

	goingDown := false
	row := 0

	result := make([]string, numRows)

	for _, ch := range s {

		result[row] += string(ch)

		if row == 0 || row == numRows-1 {
			goingDown = !goingDown
		}
		if goingDown {
			row++
		} else {
			row--
		}
	}
	res := ""
	for _, st := range result {
		res += st
	}
	return res
}
