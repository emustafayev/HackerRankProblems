package main

import "fmt"

func main() {
	fmt.Println(spiralMatrix(4, 5, nil))
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func spiralMatrix(m int, n int, head *ListNode) [][]int {

	matrix := make([][]int, m)

	for i := 0; i < m; i++ {
		matrix[i] = make([]int, n)
		for j := 0; j < n; j++ {
			matrix[i][j] = -1
		}
	}
	directions := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
	x, y := 0, 0
	dir := 0

	for head != nil {

		matrix[x][y] = head.Val
		head = head.Next

		newX, newY := x+directions[dir][0], y+directions[dir][1]

		if newX < 0 || newX >= m || newY < 0 || newY >= n || matrix[newX][newY] != -1 {
			dir = (dir + 1) % 4
			newX, newY = x+directions[dir][0], y+directions[dir][1]
		}

		x, y = newX, newY
	}

	return matrix
}
