package main

import "fmt"

func main() {
	quickSort([]int{1, 3, 5, 2, 4, 6, 7, 8, 9, 10})
}

func quickSort(arr []int) {
	_quickSort(arr, 0, len(arr)-1)
	fmt.Println(arr)
}

func _quickSort(arr []int, left, right int) {

	if left < right {
		p := partition(arr, left, right)
		_quickSort(arr, left, p-1)
		_quickSort(arr, p+1, right)
	}

}

func partition(arr []int, left, right int) int {
	pivot := arr[right]
	i := left
	for j := left; j < right; j++ {
		if arr[j] < pivot {
			arr[i], arr[j] = arr[j], arr[i]
			i++
		}
	}
	arr[i], arr[right] = arr[right], arr[i]
	return i
}
