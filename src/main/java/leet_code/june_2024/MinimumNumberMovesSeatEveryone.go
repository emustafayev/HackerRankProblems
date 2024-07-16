package main

import (
	"slices"
)

func main() {

}

//1,3,5
//2,4,7

func minMovesToSeat(seats []int, students []int) int {
	slices.Sort(seats)
	slices.Sort(students)
	res := 0
	for i := 0; i < len(seats); i++ {
		res += abs(seats[i] - students[i])
	}
	return res
}

func abs(a int) int {
	if a < 0 {
		return a * -1
	}
	return a
}
