package main

import "fmt"

func main() {

	fmt.Println(generate(5))
}

func generate(numRows int) [][]int {

	if numRows == 1 {
		return [][]int{{1}}
	}

	triangle := generate(numRows - 1)

	prev := triangle[len(triangle)-1]

	newRow := make([]int, 0)

	newRow = append(newRow, 1)

	for i := 1; i < len(prev); i++ {
		newRow = append(newRow, prev[i-1]+prev[i])
	}

	newRow = append(newRow, 1)

	triangle = append(triangle, newRow)

	return triangle
}
