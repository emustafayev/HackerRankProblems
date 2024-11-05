package main

import "fmt"

func main() {

	fmt.Println(mergeSort([]int{4, 2, 5, 6, 7, 1, 33}))
}

func mergeSort(arr []int) []int {

	return _Merge(arr)
}

func _Merge(arr []int) []int {
	if len(arr) < 2 {
		return arr
	}

	var middle = len(arr) / 2
	var a = _Merge(arr[:middle])
	var b = _Merge(arr[middle:])

	return merge_(a, b)

}

func merge_(a []int, b []int) []int {

	res := make([]int, len(a)+len(b))

	i := 0
	j := 0

	for i < len(a) && j < len(b) {
		if a[i] <= b[j] {
			res[i+j] = a[i]
			i++
		} else {
			res[i+j] = b[j]
			j++
		}

	}

	for i < len(a) {
		res[i+j] = a[i]
		i++
	}
	for j < len(b) {
		res[i+j] = b[j]
		j++
	}
	return res
}
