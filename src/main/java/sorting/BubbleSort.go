package main

import (
	"fmt"
	"github.com/TheAlgorithms/Go/constraints"
)

func Bubble[T constraints.Ordered](arr []T) []T {
	swapped := true
	for swapped {
		swapped = false
		for i := 0; i < len(arr)-1; i++ {
			if arr[i] > arr[i+1] {
				arr[i], arr[i+1] = arr[i+1], arr[i]
				swapped = true
			}
		}
	}
	return arr
}

func main() {
	fmt.Println(Bubble([]int{1, 6, 8, 3}))
}
