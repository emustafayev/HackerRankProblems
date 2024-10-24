package main

import "sort"

func main() {

}

func smallestChair(times [][]int, targetFriend int) int {

	sort.Slice(times, func(i, j int) bool {
		return times[i][0] < times[j][0]
	})

	chairs := make([]bool, len(times))

	for i := 0; i < len(times); i++ {
		if chairs[times[i][1]] {
			continue
		}
	}

	return -1
}
