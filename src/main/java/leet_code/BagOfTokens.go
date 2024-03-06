package main

import (
	"fmt"
	"slices"
)

func main() {

	//fmt.Println(bagOfTokensScore([]int{100, 300, 200, 400}, 200))
	fmt.Println(bagOfTokensScore([]int{100, 200}, 150))
}

func bagOfTokensScore(tokens []int, power int) int {
	slices.Sort(tokens)
	if len(tokens) == 0 {
		return 0
	}
	l := 0
	r := len(tokens) - 1
	score := 0
	maxScore := 0
	for l <= r {
		if tokens[l] <= power {
			power = power - tokens[l]
			score++
			l++
			maxScore = maxXX(maxScore, score)
		} else if score > 0 {
			power += tokens[r]
			score--
			r--
		} else {
			break
		}
	}
	return maxScore
}

func maxXX(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
