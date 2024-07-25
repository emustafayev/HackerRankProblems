package main

import "fmt"

func main() {
	res := sortArrayQuick([]int{4, 6, 1, 2, 9, 5, 3, 7})

	fmt.Println(res)

}

func sortArrayQuick(ints []int) interface{} {
	sortQ(ints, 0, len(ints)-1)
	return ints
}

func sortQ(ints []int, low, high int) {

	if low < high {

		pivotIndex := partition(ints, low, high)

		sortQ(ints, low, pivotIndex-1)
		sortQ(ints, pivotIndex+1, high)

	}
}

func partition(ints []int, low, high int) int {

	pivot := ints[high]
	i := low - 1

	for j := low; j < high; j++ {
		if ints[j] < pivot {
			i++
			ints[i], ints[j] = ints[j], ints[i]
		}
	}
	ints[i+1], ints[high] = pivot, ints[i+1]

	return i + 1
}
