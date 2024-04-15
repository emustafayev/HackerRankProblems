package main

import "fmt"

func main() {
	fmt.Println(countStudents([]int{1, 1, 0, 0}, []int{0, 1, 0, 1}))
	fmt.Println(countStudents([]int{1, 1, 1, 0, 0, 1}, []int{1, 0, 0, 0, 1, 1}))
}

func countStudents(students []int, sandwiches []int) int {

	count := make([]int, 2)

	for _, choice := range students {
		count[choice]++
	}

	for _, sandwich := range sandwiches {

		if count[sandwich] == 0 {
			break
		}
		count[sandwich]-- // No need to track witch student will eat.
		//We know for sure that one of them will eat
	}

	return count[0] + count[1]
}

type pair struct {
	index int
	val   int
}

func countStudents2(students []int, sandwiches []int) int {

	// sandwihcher are stack
	// student are in queue
	si := 0
	count := 0
	for si < len(sandwiches) {
		if count == len(students) {
			break
		}
		// if equals
		if sandwiches[si] == students[0] {
			students = students[1:] // remove it from the queue
			si++
			count = 0
		} else {
			temp := students[0]
			copy(students[:], students[1:])
			students[len(students)-1] = temp
			count++
		}

	}

	return len(students)
}
