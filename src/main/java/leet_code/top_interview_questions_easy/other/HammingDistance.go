package main

import "fmt"

func main() {
	fmt.Println(hammingDistance(1, 4))
}

func hammingDistance(x int, y int) int {
	dist := 0
	for i := 0; i < 32; i++ {
		if (x & 1) != (y & 1) {
			dist++
		}
		x = x >> 1
		y = y >> 1
	}
	return dist
}
