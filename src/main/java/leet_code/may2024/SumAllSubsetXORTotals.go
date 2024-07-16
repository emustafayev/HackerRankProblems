package main

func main() {

}

func subsetXORSum(nums []int) int {
	sumTotal := 0

	for _, num := range nums {
		sumTotal |= num
	}
	return sumTotal << (len(nums) - 1)
}

func subsetXORSum2(nums []int) int {
	return helper(nums, 0, 0)
}

func helper(nums []int, index, currValue int) int {
	if index == len(nums) {
		return currValue
	}
	return helper(nums, index+1, currValue^nums[index]) + helper(nums, index+1, currValue)
}
