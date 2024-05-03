package main

import (
	"fmt"
	"strconv"
	"strings"
)

func main() {
	fmt.Println(compareVersion("1.01", "1.001"))
	fmt.Println(compareVersion("0.1", "1.1"))
	fmt.Println(compareVersion("1.0.1", "1"))
}

func compareVersion(version1 string, version2 string) int {

	split1 := strings.Split(version1, ".")
	split2 := strings.Split(version2, ".")

	for i := 0; i < len(split1) || i < len(split2); i++ {
		num1, _ := strconv.Atoi(removeLeadingZeros(getVersion(split1, i)))
		num2, _ := strconv.Atoi(removeLeadingZeros(getVersion(split2, i)))
		if num1 == num2 {
			continue
		} else if num1 > num2 {
			return 1
		} else {
			return -1
		}
	}
	return 0
}

func getVersion(s []string, i int) string {
	if i >= len(s) {
		return "0"
	}
	return s[i]
}

func removeLeadingZeros(s string) string {
	i := 0
	for i = 0; i < len(s); i++ {
		if s[i] != 0 {
			break
		}
	}
	return s[i:]
}
