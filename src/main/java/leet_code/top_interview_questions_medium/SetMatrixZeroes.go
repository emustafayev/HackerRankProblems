package main

import "fmt"

func main() {

	setZeroes([][]int{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}})

}

func setZeroes(matrix [][]int) {

	rowsZero := make([]bool, len(matrix))
	colsZero := make([]bool, len(matrix[0]))

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {

			if matrix[i][j] == 0 {
				rowsZero[i] = true
				colsZero[j] = true
			}
		}
	}

	for i := 0; i < len(matrix); i++ {
		if rowsZero[i] == true {
			for j := 0; j < len(matrix[0]); j++ {
				matrix[i][j] = 0
			}
		}
	}

	for i := 0; i < len(matrix[0]); i++ {
		if colsZero[i] == true {
			for j := 0; j < len(matrix); j++ {
				matrix[j][i] = 0
			}
		}
	}
	fmt.Println(matrix)
}
