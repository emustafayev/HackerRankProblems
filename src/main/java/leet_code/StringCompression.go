package main

import (
	"strconv"
)

func main() {
	compress([]byte{'a', 'a', 'a', 'b', 'b', 'c'})
}

func compress(chars []byte) int {
	l, r := 0, 0

	for r < len(chars) {
		j := r + 1
		for ; j < len(chars) && chars[j] == chars[j-1]; j++ {
		}

		chars[l] = chars[r]
		l++
		if j != r+1 {
			for _, number := range strconv.Itoa(j - r) {
				chars[l] = byte(number)
				l++
			}
		}
		r = j
	}

	chars = chars[:l]
	return len(chars)
}

func compress2(chars []byte) int {
	newLen := 1
	compressed := []byte{}
	charCount := 1
	var charCached byte
	for reader := 0; reader < len(chars); reader++ {
		addCurrentChar := false
		isCompressable := false
		char := chars[reader]
		if reader != 0 {
			lastChar := reader+1 == len(chars)
			if char == charCached {
				charCount++
				if lastChar {
					isCompressable = true
				}
			} else {
				isCompressable = true
				if lastChar {
					addCurrentChar = true
				}
			}

			if isCompressable {
				compressed = append(compressed, charCached)
				if charCount > 1 {
					for _, v := range strconv.Itoa(charCount) {
						compressed = append(compressed, byte(v))
					}
				}
				charCount = 1
			}
			if addCurrentChar {
				compressed = append(compressed, char)
			}
			newLen = len(compressed)
		}
		charCached = char
	}

	for i, v := range compressed {
		chars[i] = v
	}

	return newLen
}
