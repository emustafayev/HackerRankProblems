package main

import "fmt"

func main() {
	fmt.Println(reverseVowels("leetcode"))
	fmt.Println(reverseVowels("hello"))
}

func reverseVowels(s string) string {
	l := 0
	r := len(s) - 1
	sArr := make([]int, len(s))
	for i, ch := range s {
		sArr[i] = int(ch)
	}
	for l < r {
		for l < r && !isVowel(sArr[l]) {
			l++
		}
		for l < r && !isVowel(sArr[r]) {
			r--
		}
		sArr[r], sArr[l] = sArr[l], sArr[r]
		l++
		r--
	}
	resStr := ""
	for _, ch := range sArr {
		resStr += string(rune(ch))
	}
	return resStr
}

var vowels = []int{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'}

func isVowel(ch int) bool {
	for _, el := range vowels {
		if ch == el {
			return true
		}
	}
	return false
}

func reverseVowels2(s string) string {
	bs := []byte(s)
	for i, j := 0, len(bs)-1; i < j; {
		// fmt.Println(i,j)
		if !isVowel2(bs[i]) {
			i++
			continue
		}
		if !isVowel2(bs[j]) {
			j--

			continue
		}

		bs[i], bs[j] = bs[j], bs[i]

		i++
		j--
	}
	return string(bs)
}

func isVowel2(b byte) bool {
	// fmt.Println(b == 'e')
	return b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u' || b == 'A' || b == 'E' || b == 'I' || b == 'O' || b == 'U'
}
