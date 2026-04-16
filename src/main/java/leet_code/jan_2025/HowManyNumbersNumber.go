package main

func main() {

	smallerNumbersThanCurrent([]int{8, 1, 2, 2, 3})
}

func smallerNumbersThanCurrent(nums []int) []int {
	const K = 101
	freq := make([]int, K)
	// Count frequencies
	for _, x := range nums {
		freq[x]++
	}
	// Build prefix sum: prefix[v] = # of elements < v
	prefix := make([]int, K)
	for v := 1; v < K; v++ {
		prefix[v] = prefix[v-1] + freq[v-1]
	}
	// Answer for each num is prefix[num]
	res := make([]int, len(nums))
	for i, x := range nums {
		res[i] = prefix[x]
	}
	return res
}

func smallerNumbersThanCurrent2(nums []int) []int {
	var my_list []int

	for i := 0; i < len(nums); i++ {
		count := 0
		for j := 0; j < len(nums); j++ {
			if nums[j] < nums[i] && i != j {
				count++
			}
		}
		my_list = append(my_list, count)
	}
	return my_list
}
