package main

func main() {

}

func intersect(nums1 []int, nums2 []int) []int {
	var result []int
	numCount := make(map[int]int)
	for _, num := range nums1 {
		numCount[num]++
	}

	for _, num := range nums2 {
		if count, ok := numCount[num]; ok && count > 0 {
			result = append(result, num)
			numCount[num]--
		}
	}
	return result
}
