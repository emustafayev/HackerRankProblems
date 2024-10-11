package main

func main() {

}

func isValidSudoku(board [][]byte) bool {
	var rows, cols, boxes [9][9]bool
	for i, row := range board {
		for j, el := range row {
			if el != '.' {
				v := int(el) - 49
				if rows[i][v] || cols[j][v] || boxes[i/3*3+j/3*1][v] {
					return false
				}
				rows[i][v], cols[j][v], boxes[i/3*3+j/3][v] = true, true, true
			}
		}
	}

	return true
}
