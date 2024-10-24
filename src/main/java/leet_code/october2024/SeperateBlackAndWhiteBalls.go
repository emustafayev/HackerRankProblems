package main

import "fmt"

func main() {

	fmt.Println(minimumSteps3("101"))
	fmt.Println(minimumSteps3("100"))
	fmt.Println(minimumSteps3("0111"))
	fmt.Println(minimumSteps3("11000111"))

}

func minimumSteps(s string) int64 {

	var res int64 = 0
	var zeros int64 = 0

	for i := len(s) - 1; i >= 0; i-- {
		if s[i] == '0' {
			zeros += 1
		} else {
			res += zeros
		}
	}

	return res
}

func minimumSteps2(s string) int64 {

	var totalSwaps int64 = 0
	whitePosition := 0

	for currentPos := 0; currentPos < len(s); currentPos++ {

		if s[currentPos] == '0' {
			totalSwaps += int64(currentPos - whitePosition)
			whitePosition++
		}
	}

	return totalSwaps
}

func minimumSteps3(s string) int64 {

	n := len(s)
	var res int64 = 0
	l, r := 0, n-1

	for l < r {

		if s[l] == '0' {
			l++
			continue
		}
		if s[r] == '1' {
			r--
			continue
		}

		res += int64(r - l)
		r--
		l++

	}

	return res
}
