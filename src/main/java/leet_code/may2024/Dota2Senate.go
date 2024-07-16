package main

import "fmt"

func main() {
	fmt.Println(predictPartyVictory("RDD"))
	fmt.Println()
	fmt.Println(predictPartyVictory("RD"))
}

func predictPartyVictory(senate string) string {

	var rad []int
	var dir []int

	for i, s := range senate {

		if s == 'R' {
			rad = append(rad, i)
		} else {
			dir = append(dir, i)
		}
	}

	index := len(senate)

	for len(dir) > 0 && len(rad) > 0 {
		index++
		d := dir[0]
		dir = dir[1:]

		r := rad[0]
		rad = rad[1:]

		if r < d {
			rad = append(rad, index)
		} else {
			dir = append(dir, index)
		}
	}

	if len(dir) > 0 {
		return "Dire"
	} else {
		return "Radian"
	}
}
