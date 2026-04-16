package main

func main() {
	findDisappearedNumbers([]int{4, 3, 2, 7, 8, 2, 3, 1})
}

func findDisappearedNumbers(nums []int) []int {
	// Pass 1: Mark existing numbers by negating the value at the corresponding index
	for _, v := range nums {
		// Use absolute value since the number might have been negated already
		absV := v
		if absV < 0 {
			absV = -absV
		}

		index := absV - 1
		if nums[index] > 0 {
			nums[index] = -nums[index]
		}
	}

	// Pass 2: Collect indices that are still positive
	var res []int
	for i, v := range nums {
		if v > 0 {
			res = append(res, i+1)
		}
	}
	return res
}
