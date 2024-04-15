package main

func main() {

}

func numSpecial(mat [][]int) int {

	res := 0

	for i := 0; i < len(mat); i++ {
		for j := 0; j < len(mat[0]); j++ {
			if mat[i][j] == 1 {
				if checkRow(i, j, mat) && checkCol(i, j, mat) {
					res++
				}
			}
		}
	}
	return res

}

func checkCol(_row int, col int, mat [][]int) bool {
	for row := 0; row < len(mat); row++ {
		if row != _row && mat[row][col] == 1 {
			return false
		}
	}
	return true
}

func checkRow(row, _col int, mat [][]int) bool {
	for col := 0; col < len(mat[0]); col++ {
		if col != _col && mat[row][col] == 1 {
			return false
		}
	}
	return true
}
