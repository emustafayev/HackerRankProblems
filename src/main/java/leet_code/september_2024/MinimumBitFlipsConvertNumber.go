package main

import (
	"math/bits"
)

func main() {

	minBitFlips(10, 7)
}

func minBitFlips(start int, goal int) int {
	count := 0
	xor := start ^ goal
	for xor != 0 {
		// If the last bit is 1, increment count
		count += xor & 1
		// Right-shift to check the next bit
		xor >>= 1
	}
	return -1
}

func minBitFlips2(start int, goal int) int {
	return bits.OnesCount(uint(start ^ goal))
}
