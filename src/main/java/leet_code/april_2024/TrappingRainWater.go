package main

import "fmt"

func main() {

	fmt.Println(trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
}

func trap(height []int) int {

	i := 0
	res := 0

	for i < len(height) {

		runner := i + 1
		pool := 0
		for runner < len(height) && height[i] > height[runner] {
			fmt.Printf("%v %v\n", i, runner)
			pool += height[i] - height[runner]
			runner++
		}
		res += pool
		i = runner

	}

	return res
}
