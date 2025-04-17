package main

import "fmt"

func main() {

	fmt.Println(areAlmostEqual("bank", "kanb"))
	fmt.Println(areAlmostEqual("bank", "kanc"))
}

func areAlmostEqual(s1 string, s2 string) bool {

	//If they equal we don't need to swap
	if s1 == s2 {
		return true
	}

	//If they are not equal and length is not equal we can't swap
	if len(s1) != len(s2) {
		return false
	}

	var diffIndex []int

	//Find the indexes where the strings are different
	for i := 0; i < len(s1); i++ {
		if s1[i] != s2[i] {
			diffIndex = append(diffIndex, i)
		}
	}

	//If there are more than 2 indexes different we can't swap at most 2 indexes
	if len(diffIndex) != 2 {
		return false
	}

	//If the characters at the different indexes are equal we can swap
	if s1[diffIndex[0]] == s2[diffIndex[1]] && s1[diffIndex[1]] == s2[diffIndex[0]] {
		return true
	} else {
		return false
	}

}
