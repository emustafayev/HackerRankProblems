package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Println(minimumAverageDifference3([]int{2, 5, 3, 9, 5, 3}))
}

//You are given a 0-indexed integer array nums of length n.
//
//The average difference of the index i is the absolute difference between the
//average of the first i + 1 elements of nums and the average of the last n - i - 1 elements.
//	Both averages should be rounded down to the nearest integer.
//
//Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
//
//Note:
//
// - The absolute difference of two numbers is the absolute value of their difference.
// - The average of n elements is the sum of the n elements divided (integer division) by n.
// - The average of 0 elements is considered to be 0.
//

func minimumAverageDifference(nums []int) int {
	averages := make([]int, len(nums))

	leftSum := 0
	rightSum := 0

	for _, num := range nums {
		rightSum += num
	}

	n := len(nums)

	for i, num := range nums {
		averages[i], leftSum, rightSum = calculateAverage(num, leftSum, rightSum, i, n)
		fmt.Println(num)
	}

	listIndex := 0
	min := math.MaxInt

	for i, avr := range averages {

		if avr < min {
			min = avr
			listIndex = i
		}
	}

	fmt.Println(averages)
	return listIndex
}

func calculateAverage(num int, leftSum int, rightSum int, i int, n int) (int, int, int) {
	leftSum += num
	rightSum -= num
	right := 0

	if rightSum > 0 {
		right = int(math.Ceil(float64(rightSum / (n - i - 1))))
	} else {
		right = 0
	}
	return int(math.Abs(
		float64(int(
			math.Ceil(
				float64(leftSum/(i+1)),
			),
		) - right))), leftSum, rightSum
}

//-------------------------------------------------------------------------------------

func minimumAverageDifference2(nums []int) int {
	n := len(nums)
	if n == 1 {
		return 0
	}

	var sum1 int
	var sum2 int
	for i := range nums {
		sum2 += nums[i]
	}
	diff := sum2/n + 1
	x := -1
	for i := range nums {
		sum1 += nums[i]
		sum2 -= nums[i]
		a1 := sum1 / (i + 1)
		var a2 int
		if sum2 > 0 {
			a2 = sum2 / (n - i - 1)
		}
		d := abs(a1 - a2)
		if diff > d {
			x = i
			diff = d
		}
	}
	return x
}

func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}

//-------------------------------------------------------------------------------------

func minimumAverageDifference3(nums []int) int {
	leftSum := 0
	rightSum := 0

	for _, num := range nums {
		rightSum += num
	}

	n := len(nums)
	x := -1
	diff := rightSum/n + 1

	for i, num := range nums {
		leftSum += num
		rightSum -= num
		var a1 = 0
		if rightSum > 0 {
			a1 = rightSum / (n - i - 1)
		}
		var a2 = leftSum / (i + 1)

		d := abs(a1 - a2)

		if diff > d {
			x = i
			diff = d
		}

	}

	return x
}
