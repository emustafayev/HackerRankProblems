package main

import (
	"fmt"
	"strconv"
)

func main() {
	//
	//grid := [][]int{
	//	{3, 2, 1},
	//	{1, 7, 6},
	//	{2, 7, 7},
	//}
	grid2 := [][]int{
		{11, 1},
		{1, 11},
	}

	//fmt.Println(equalPairs(grid))

	fmt.Println(equalPairs(grid2))
}

func equalPairs(grid [][]int) int { // slow

	row := make(map[int]string, len(grid))
	col := make(map[int]string, len(grid[0]))

	var encode func(arr []int) string
	encode = func(arr []int) string {
		enc := ""
		for _, el := range arr {
			enc += strconv.Itoa(el)
			enc += "|"
		}
		return enc
	}

	for i := 0; i < len(grid); i++ {
		row[i] = encode(grid[i])
	}
	for i := 0; i < len(grid[0]); i++ {
		arr := []int{}
		for j := 0; j < len(grid); j++ {
			arr = append(arr, grid[j][i])
		}
		col[i] = encode(arr)
	}

	res := 0

	fmt.Println(row)
	fmt.Println(col)

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			if row[i] == col[j] {
				res++
			}
		}
	}
	return res
}
