package main

import "fmt"

func main() {

	fmt.Println(intersect([]int{1, 2, 2, 1}, []int{2, 2}))

}

func intersect(nums1 []int, nums2 []int) []int {

	n1m := map[int]int{}
	n2m := map[int]int{}

	for _, num := range nums1 {
		n1m[num]++
	}

	for _, num := range nums2 {
		n2m[num]++
	}
	var res []int
	for k, v := range n1m {

		if n2m[k] != 0 {
			appendToRes(&res, k, v, n2m[k])
		}
	}

	return res
}

func appendToRes(res *[]int, k int, c1 int, c2 int) {

	t := min(c1, c2)

	for t > 0 {
		*res = append(*res, k)
		t--
	}

}

func intersect2(nums1 []int, nums2 []int) []int {
	numCount := make(map[int]int)

	var res []int

	for _, num := range nums1 {
		numCount[num]++
	}

	for _, num := range nums2 {

		if numCount[num] > 0 {
			res = append(res, num)
			numCount[num]--
		}
	}
	return res
}
