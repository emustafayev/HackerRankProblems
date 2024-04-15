package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Println(oddString([]string{"aaa", "bob", "ccc", "ddd"}))
	fmt.Println(oddString([]string{"ddd", "poo", "baa", "onn"}))
}

func oddString(words []string) string {

	var newGen [][]int
	for _, word := range words {
		var gen []int
		for i := 1; i < len(word); i++ {
			gen = append(gen, int(word[i])-int(word[i-1]))
		}

		newGen = append(newGen, gen)
	}
	fmt.Println(newGen)
	return words[findDifferentElement(newGen)]
}

// Fixme: Not working if first element is different
func findDifferentElement(arr [][]int) int {
	// Initialize variables
	referenceArray := arr[0]

	// Iterate through the arrays starting from the second one
	for i := 1; i < len(arr); i++ {
		// Compare each element of the current array with the reference array
		for j := 0; j < len(arr[i]); j++ {
			if arr[i][j] != referenceArray[j] {
				// If elements are different, return the index
				if i+1 < len(arr) {
					if arr[i][j] == arr[i+1][j] {
						return i - 1
					}
				}
				return i
			}
		}
	}

	// If no different array is found, return -1
	return -1
}

func oddString2(words []string) string {

	sign := ""
	for _, word := range words {

		newSign := ""
		for i := 1; i < len(word); i++ {
			newSign = newSign + ":" + strconv.Itoa(int(word[i])-int(word[i-1])) + ":" + strconv.Itoa(i)
		}

		fmt.Println(newSign)

		if newSign != sign {
			fmt.Println("")
			fmt.Println(newSign)
			sign = newSign
		}
	}

	fmt.Println(sign)

	return ""
}
