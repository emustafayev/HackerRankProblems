package main

func main() {

	removeDuplicates([]int{0, 1, 1, 1, 2, 2, 3, 3, 4})
}

func removeDuplicates(nums []int) int {

	index := 1 // first replaceable element

	//start comparing from scratch normally

	for i := 1; i < len(nums); i++ {

		if nums[i] != nums[i-1] {
			nums[index] = nums[i]
			index++
		}
	}
	return index

}
