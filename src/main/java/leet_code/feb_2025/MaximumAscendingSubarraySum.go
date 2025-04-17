package main

import "fmt"

func main() {

	fmt.Println(maxAscendingSum([]int{10, 20, 30, 5, 10, 50}))

}

func maxAscendingSum(nums []int) int {

	maxSum := nums[0]

	for i := 0; i < len(nums); i++ {

		sums := nums[i]

		j := i + 1
		for j < len(nums) && nums[j] > nums[j-1] {
			sums += nums[j]
			j++
		}
		maxSum = max(maxSum, sums)
	}
	return maxSum
}

func maxAscendingSum2(nums []int) int {
	maxSum := nums[0]
	currentSum := nums[0]

	for i := 1; i < len(nums); i++ {
		if nums[i] > nums[i-1] {
			currentSum += nums[i]
		} else {
			currentSum = nums[i]
		}

		if currentSum > maxSum {
			maxSum = currentSum
		}
	}

	return maxSum
}
