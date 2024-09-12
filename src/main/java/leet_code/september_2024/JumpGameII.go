package main

func main() {

	jump([]int{2, 3, 0, 1, 4})
}
func jump(nums []int) int {
	if len(nums) == 1 {
		// No jump needed if there is only one element
		return 0
	}

	// jumps counts the number of jumps needed
	jumps := 0
	// currentEnd marks the end of the range that we can reach with the current number of jumps
	currentEnd := 0
	// farthest marks the farthest point that can be reached with the current number of jumps
	farthest := 0

	for i := 0; i < len(nums)-1; i++ {
		// Update the farthest point we can reach
		farthest = max(farthest, i+nums[i])

		// If we have reached the end of the current range
		if i == currentEnd {
			// Increment the jump count
			jumps++
			// Update the end of the current range to the farthest point we can reach
			currentEnd = farthest

			// If we reached or exceeded the last index, break out of the loop
			if currentEnd >= len(nums)-1 {
				break
			}
		}
	}

	return jumps
}

// max returns the greater of two integers
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
