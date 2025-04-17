package main

func main() {

}
func check(nums []int) bool {

	swap := 0
	n := len(nums)
	for i := 0; i < n; i++ {
		if nums[i] > nums[(i+1)%n] {
			swap++
		}
	}
	return swap <= 1
}
