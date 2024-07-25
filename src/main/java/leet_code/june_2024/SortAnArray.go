package main

import "fmt"

func main() {
	res := sortArray([]int{4, 6, 1, 2, 9, 5, 3, 7})

	fmt.Println(res)

}

func sortArray(nums []int) []int {

	sort(nums, 0, len(nums)-1)
	return nums
}

func sort(nums []int, l, r int) {

	if l < r {
		m := l + (r-l)/2

		sort(nums, l, m)
		sort(nums, m+1, r)

		merge(nums, l, m, r)
	}

}

func merge(nums []int, l, m, r int) {

	//Subarray length
	n1 := m - l + 1
	n2 := r - m

	L := make([]int, n1)
	R := make([]int, n2)

	copy(L, (nums)[l:m+1])
	copy(R, (nums)[m+1:r+1])

	i := 0
	j := 0
	k := l

	for i < n1 && j < n2 {
		if L[i] <= R[j] {
			(nums)[k] = L[i]
			i++
		} else {
			(nums)[k] = R[j]
			j++
		}
		k++
	}

	for i < n1 {
		(nums)[k] = L[i]
		i++
		k++
	}

	for j < n2 {
		(nums)[k] = R[j]
		j++
		k++
	}
}
