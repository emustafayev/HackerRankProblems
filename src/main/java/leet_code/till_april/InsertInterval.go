package main

func insert(intervals [][]int, newInterval []int) [][]int {

	newIntervals := [][]int{}

	for i := 0; i < len(intervals); i++ {
		interval := intervals[i]

		if newInterval[0] < interval[1] {

			continue
		}

		newIntervals = append(newIntervals, interval)

	}
}
