package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Println(findMinArrowShots([][]int{{10, 16}, {2, 8}, {1, 6}, {7, 12}}))
}

func findMinArrowShots(points [][]int) int {

	sort.Slice(points, func(i, j int) bool {
		return points[i][1] < points[j][1]
	})

	arrow := 1
	prev := points[0]

	for i := 1; i < len(points); i++ {

		fmt.Println()

		if prev[1] < points[i][0] { // dont overlap add one more arrow
			arrow++
			prev = points[i]
		}
	}

	return arrow
}
