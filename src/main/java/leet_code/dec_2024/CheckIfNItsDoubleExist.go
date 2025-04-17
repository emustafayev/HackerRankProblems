package main

import "fmt"

func main() {
	fmt.Println(checkIfExist([]int{10, 2, 5, 3}))
	fmt.Println(checkIfExist([]int{10, 2, 7, 3}))
}

func checkIfExist(arr []int) bool {
	set := make(map[int]bool)

	for _, v := range arr {
		if set[v*2] {
			return true
		}
		if v%2 == 0 && set[v/2] {
			return true
		}
		set[v] = true
	}
	return false
}
