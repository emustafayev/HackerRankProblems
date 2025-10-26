package main

import "fmt"

func main() {

	fmt.Println(hasSameDigits("3902"))
}

/**
For each pair of consecutive digits in s, starting from the first digit, calculate a new digit as the sum of the two digits modulo 10.
Replace s with the sequence of newly calculated digits, maintaining the order in which they are computed.
*/

func hasSameDigits(s string) bool {
	for len(s) <= 2 {
		return s[0] == s[1]
	}

	for len(s) > 2 {
		newS := ""
		for i := 0; i < len(s)-1; i++ {

			newS += string(((s[i] - '0' + s[i+1] - '0') % 10) + '0')
		}
		s = newS
	}

	return s[0] == s[1]

}

func hasSameDigits2(s string) bool {
	b := []byte(s)
	length := len(s)
	i := 0
	for i = range b {
		b[i] -= '0'
	}

	for length > 2 {
		for i = 0; i < length-1; i++ {
			b[i] = (b[i] + b[i+1]) % 10
		}
		length--
	}

	return b[0] == b[1]
}
