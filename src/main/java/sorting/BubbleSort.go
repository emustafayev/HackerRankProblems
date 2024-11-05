package main

import (
	"fmt"
)

func Bubble(arr []int) []int {
	swapped := false

	for i := 0; i < len(arr); i++ {

		for j := 0; j < len(arr)-1; j++ {
			if arr[j] > arr[j+1] {
				arr[j], arr[j+1] = arr[j+1], arr[j]
				swapped = true
			}
		}
		if !swapped {
			break
		}
	}

	return arr
}

func main() {
	fmt.Println(Bubble([]int{1, 6, 8, 3}))
}
