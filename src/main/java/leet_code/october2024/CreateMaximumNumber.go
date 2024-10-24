package main

import (
	"fmt"
	"sort"
)

func main() {

	fmt.Println(maxNumber([]int{3, 4, 6, 5}, []int{9, 1, 2, 5, 8, 3}, 5))

}

// Relative order not considered. Wrong approach
func maxNumber(nums1 []int, nums2 []int, k int) []int {

	p1 := 0
	p2 := 0

	sort.Slice(nums1, func(i, j int) bool {
		return nums1[i] > nums1[j]
	})

	sort.Slice(nums2, func(i, j int) bool {
		return nums2[i] > nums2[j]
	})

	res := make([]int, k)

	for i := 0; i < k; i++ {

		if p2 == len(nums2) || nums1[p1] > nums2[p2] {
			res[i] = nums1[p1]
			p1++

		} else if nums1[p1] == nums2[p2] {
			res[i] = nums1[p1]
			p1++
			p2++
		} else if nums1[p1] < nums2[p2] || p1 == len(nums1) {
			res[i] = nums2[p2]
			p2++
		}
	}
	return res
}
