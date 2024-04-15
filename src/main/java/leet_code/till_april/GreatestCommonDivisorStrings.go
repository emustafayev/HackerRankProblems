package main

import "fmt"

func main() {
	fmt.Println(gcdOfStrings("ABCABC", "ABC"))
	fmt.Println(gcdOfStrings("ABABAB", "ABAB"))
}

func gcdOfStrings(str1 string, str2 string) string {
	if (str1 + str2) != str2+str1 {
		fmt.Println("worked i")
		return ""
	}
	minL := minGcd(len(str1), len(str2))
	maxL := maxGcd(len(str1), len(str2))
	for minL > 0 {
		maxL, minL = minL, maxL%minL
	}
	return str1[0:maxL]

}

func minGcd(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func maxGcd(a, b int) int {
	if a > b {
		return a
	}
	return b
}
