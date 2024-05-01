package main

import "fmt"

func main() {

	arr := []int{3, 4, 7, 8, 9}

	data := 12

	for i := 0; i < len(arr); i++ {
		data ^= arr[i]
	}

	fmt.Println(data)

	lastEl := arr[len(arr)-1]

	for i := 0; i < len(arr); i++ {
		newEl := data ^ lastEl
		data, lastEl = newEl, data
		fmt.Println(newEl)
	}

}
