package main

import (
	"fmt"
)

func main() {

	fmt.Println(romanToInt("LVIII"))
	fmt.Println(romanToInt("III"))
	fmt.Println(romanToInt2("MCMXCIV"))
	fmt.Println(romanToInt("DCXXI"))

}

func romanToInt(s string) int {

	var romanMap = map[string]int{
		"I": 1,
		"V": 5,
		"X": 10,
		"L": 50,
		"C": 100,
		"D": 500,
		"M": 1000,
	}

	var prev byte

	res := 0
	prev = 'A'

	for i := len(s) - 1; i >= 0; i-- {

		if checkAndApplySubs(s[i], &prev, &res, romanMap, 'V', 'X', 'I') {
			continue
		}
		if checkAndApplySubs(s[i], &prev, &res, romanMap, 'L', 'C', 'X') {
			continue
		}

		if checkAndApplySubs(s[i], &prev, &res, romanMap, 'D', 'M', 'C') {
			continue
		}

		res += romanMap[string(s[i])]
		prev = s[i]
	}

	return res
}

func checkAndApplySubs(current byte, prev *byte, res *int, romanMap map[string]int, case1 byte, case2 byte, prob byte) bool {
	if current == prob && *prev != 'A' && (*prev == case1 || *prev == case2) {
		*res -= romanMap[string(current)]
		*prev = current
		return true
	}
	return false
}

func romanToInt2(s string) int {
	romanMap := map[byte]int{
		'I': 1,
		'V': 5,
		'X': 10,
		'L': 50,
		'C': 100,
		'D': 500,
		'M': 1000,
	}

	res := 0
	prev := 0

	// Traverse the string from right to left
	for i := len(s) - 1; i >= 0; i-- {
		current := romanMap[s[i]]

		// If the current value is less than the previous value, subtract it
		if current < prev {
			res -= current
		} else {
			// Otherwise, add it
			res += current
		}

		// Update prev to the current value
		prev = current
	}

	return res
}
