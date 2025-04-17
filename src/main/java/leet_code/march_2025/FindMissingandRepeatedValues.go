package main

func main() {

}

func findMissingAndRepeatedValues(grid [][]int) []int {
	freq := make(map[int]int)
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			freq[grid[i][j]]++
		}
	}
	res := make([]int, 2)
	for i := 1; i <= len(grid)*len(grid[0]); i++ {
		if val, found := freq[i]; found {
			if val > 1 {
				res[0] = i
			}
		} else {
			res[1] = i
		}
	}

	return res
}

// TODO: Understand the logic
func findMissingAndRepeatedValues2(grid [][]int) []int {
	n := len(grid)
	m := len(grid[0])
	xnum := 0
	for i := range grid { // Corrected "gird" to "grid"
		for j := range grid[i] {
			xnum ^= grid[i][j]
		}
	}
	for i := 1; i <= n*m; i++ { // Corrected loop condition and "xum" to "xnum"
		xnum ^= i
	}

	// find first set bit
	number := xnum & (-xnum) // Corrected to find the least significant set bit

	// grouping numbers with 0 and 1
	zero := 0
	one := 0
	for i := range grid { // Corrected "gird" to "grid"
		for j := range grid[i] {
			if number&grid[i][j] != 0 {
				one ^= grid[i][j]
			} else {
				zero ^= grid[i][j]
			}
		}
	}
	for i := 1; i <= n*m; i++ { // Corrected loop condition
		if number&i != 0 {
			one ^= i
		} else {
			zero ^= i
		}
	}

	cnt := 0
	for i := range grid { // Corrected "gird" to "grid"
		for j := range grid[i] {
			if grid[i][j] == zero {
				cnt++
			}
		}
	}

	if cnt == 2 { //Corrected to 1 as the repeated number will occur only once.
		return []int{zero, one}
	}
	return []int{one, zero}
}
