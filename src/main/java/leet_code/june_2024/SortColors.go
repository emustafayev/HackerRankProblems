package main

func main() {

}

func sortColors(nums []int) {
	counter := []int{0, 0, 0}
	for i := 0; i < len(nums); i++ {
		counter[nums[i]]++
	}
	s := 0
	for i := 0; i < len(counter); i++ {
		for counter[i] > 0 {
			nums[s] = i
			counter[i]--
			s++
		}
	}

}
