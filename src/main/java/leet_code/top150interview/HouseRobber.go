package main

func main() {

}

func rob(nums []int) int {

	if len(nums) == 1 {
		return nums[0]
	}

	if len(nums) == 2 {
		return findMax(nums[0], nums[1])
	}

	db := make(map[int]int)

	db[0] = nums[0]
	db[1] = findMax(nums[0], nums[1])

	for i := 2; i < len(nums); i++ {
		db[i] = findMax(db[i-2]+nums[i], db[i-1])
	}

	return db[len(nums)-1]
}

func findMax(a, b int) int {
	if a > b {
		return a
	}
	return b
}
