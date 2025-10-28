package main

import (
	"fmt"
	"sort"
)

func main() {

	var nums1 = []int{1, 2, 3, 0, 0, 0}

	merge2(nums1, 3, []int{2, 5, 6}, 3)

	fmt.Println(nums1)

}

func merge(nums1 []int, m int, nums2 []int, n int) {

	//1, 2, 3, 0, 0, 0
	//2, 5, 6

	for n > 0 {
		if m > 0 && nums1[m-1] > nums2[n-1] {
			nums1[m+n-1] = nums1[m-1]
			m--
		} else {
			nums1[m+n-1] = nums2[n-1]
			n--
		}
	}
}

func merge2(nums1 []int, m int, nums2 []int, n int) {
	for j, i := 0, m; j < n; j, i = j+1, i+1 {
		nums1[i] = nums2[j]
	}
	sort.Ints(nums1)
}
