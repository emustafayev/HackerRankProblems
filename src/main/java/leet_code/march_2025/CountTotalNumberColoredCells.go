package main

import "fmt"

func main() {
	fmt.Println(coloredCells(3))
}

func coloredCells(n int) int64 {
	x := int64(n)
	return 1 + 2*x*(x-1)
}

func coloredCells2(n int) int64 {

	return getColored(n)

}

func getColored(n int) int64 {
	if n == 1 {
		return 1
	}

	return int64(4*(n-1)) + getColored(n-1)
}
