package main

import "fmt"

func main() {

	fmt.Println(makeFancyString3("aaqqqqqqqqqqqqqqqqqqqqqqqqabbbbbbbbbbbbbbbbbbbbbbbbbbb"))
	//fmt.Println(makeFancyString("leeetcode"))
}

// leeetcode
// 9
// 6
func makeFancyString(s string) string {

	for i := 0; i < len(s)-2; {
		c1 := s[i]
		c2 := s[i+1]
		c3 := s[i+2]
		if c1 == c2 && c2 == c3 {
			s = s[:i+1] + s[i+2:]
		} else {
			i++
		}
	}

	return s
}

func makeFancyString3(s string) string {

	var res []byte

	for i := 0; i < len(s); i++ {
		n := len(res)
		if n < 2 || !(res[n-1] == s[i] && res[n-2] == s[i]) {
			res = append(res, s[i])
		}
	}

	return string(res)
}

func makeFancyString2(s string) string {
	result := []byte{}
	for i := 0; i < len(s); i++ {
		n := len(result)
		if n < 2 || !(result[n-1] == s[i] && result[n-2] == s[i]) {
			result = append(result, s[i])
		}
	}
	return string(result)
}
