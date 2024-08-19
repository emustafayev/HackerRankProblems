package main

func main() {

}

func minSwaps(nums []int) int {

	n := len(nums)

	totalOnes := 0

	for _, el := range nums {
		totalOnes += el
	}

	if totalOnes == n || totalOnes == 0 {
		return 0
	}

	//current window slide
	currentOnes := 0
	for i := 0; i < totalOnes; i++ {
		currentOnes += nums[i]
	}

	maxOnes := currentOnes

	for i := 0; i < n; i++ {
		currentOnes -= nums[i]
		currentOnes += nums[(i+totalOnes)%n]
		if currentOnes > maxOnes {
			maxOnes = currentOnes
		}
	}

	return totalOnes - maxOnes

}

func minSwaps2(nums []int) int {
	// "Hint1: Notice that the number of 1’s to be grouped together is fixed.
	// It is the number of 1's the whole array has."
	totalNums := 0
	for _, num := range nums {
		totalNums += num // "nums[i] is either 0 or 1"
	}

	// "Hint4: To eliminate the circular property of the array, we can append
	// the original array to itself. Then, we check each subarray of length total."
	n2 := len(nums) * 2
	doubleNums := make([]int, n2)
	copy(doubleNums, nums)
	copy(doubleNums[len(nums):], nums)

	// "Hint5: How do we avoid recounting the number of 0’s in the subarray each time?
	// The Sliding Window technique can help."
	// Prepare bas sliding window
	currenOnes := 0
	i := 0
	for ; i < totalNums; i++ {
		currenOnes += doubleNums[i]
	}
	maxOnes := currenOnes
	// Continue with sliding window
	for ; i < n2; i++ {
		currenOnes -= doubleNums[i-totalNums]
		currenOnes += doubleNums[i]
		maxOnes = max(maxOnes, currenOnes)
	}
	// The number of swaps is equal to difference overall_number_of_1s - maximum_number_of_1s_within_sliding_window
	return totalNums - maxOnes
}
