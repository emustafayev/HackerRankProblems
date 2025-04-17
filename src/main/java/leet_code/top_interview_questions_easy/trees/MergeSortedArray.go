package main

func main() {

}

func merge(nums1 []int, m int, nums2 []int, n int) {

	finalLen := m + n - 1
	midx := m - 1
	nidx := n - 1
	for nidx >= 0 {
		if midx > 0 && nums1[midx] > nums2[nidx] {
			nums1[finalLen] = nums1[midx]
			midx--
		} else {
			nums1[finalLen] = nums2[nidx]
			nidx--
		}
		finalLen--
	}

}
