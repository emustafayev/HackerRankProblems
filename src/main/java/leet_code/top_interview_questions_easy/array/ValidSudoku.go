package main

import "fmt"

func main() {

	fmt.Println(isValidSudoku([][]byte{
		{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
		{'6', '8', '.', '1', '9', '5', '.', '.', '.'},
		{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
		{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
		{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
		{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
		{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
		{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
		{'.', '.', '.', '.', '8', '.', '.', '7', '9'},
	})) // -> false

}

func isValidSudoku(board [][]byte) bool {
	for i := 0; i < len(board); i++ {
		if !isValidRow(board[i]) {
			return false
		}
	}

	for col := 0; col < len(board); col++ {
		colBytes := make([]byte, len(board))
		for row := 0; row < len(board); row++ {
			colBytes[row] = board[row][col]
		}
		if !isValidRow(colBytes) {
			return false
		}
	}

	for i := 0; i < len(board); i += 3 {
		for j := 0; j < len(board); j += 3 {
			if !isValidBox(board, i, j) {
				return false
			}
		}
	}
	return true
}

func isValidBox(board [][]byte, row, col int) bool {
	boxMap := make(map[byte]bool)
	for i := row; i < row+3; i++ {
		for j := col; j < col+3; j++ {
			if board[i][j] == '.' {
				continue
			}
			if _, found := boxMap[board[i][j]]; found {
				return false
			}
			boxMap[board[i][j]] = true
		}
	}
	return true
}

func isValidRow(rowBytes []byte) bool {
	m := make(map[byte]bool)
	for i := 0; i < len(rowBytes); i++ {
		if rowBytes[i] != '.' {
			continue
		}
		if _, found := m[rowBytes[i]]; found {
			return false
		}
		m[rowBytes[i]] = true
	}
	return true
}
