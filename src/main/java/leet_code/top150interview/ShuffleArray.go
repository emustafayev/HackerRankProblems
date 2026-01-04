package main

func main() {
	shuffle([]int{2, 5, 1, 3, 4, 7}, 3)
}

func shuffle(nums []int, n int) []int {
	res := make([]int, n*2)
	slow := 0
	fast := n
	i := 0
	for i < len(nums) {
		if i%2 == 0 {
			res[i] = nums[slow]
			slow++
		} else {
			res[i] = nums[fast]
			fast++
		}
		i++
	}
	return res
}

func shuffle2(nums []int, n int) []int {
	// using a new array
	shuffled := make([]int, n*2)
	fi, se := 0, n
	for i := 0; i < (n*2)-1; i += 2 {
		shuffled[i] = nums[fi]
		fi++
		shuffled[i+1] = nums[se]
		se++
	}
	return shuffled
}
