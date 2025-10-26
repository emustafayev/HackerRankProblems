package main

func main() {

}

func canJump(nums []int) bool {
	j := len(nums) - 1
	for i := j - 1; i >= 0; i-- {
		if j-i <= nums[i] {
			j = i
		}
	}
	return j == 0
}

func canJump2(nums []int) bool {
	prev := nums[0]
	for i := 1; i < len(nums); i++ {
		if prev == 0 {
			return false
		}
		prev = max(prev-1, nums[i])
	}
	return true
}
