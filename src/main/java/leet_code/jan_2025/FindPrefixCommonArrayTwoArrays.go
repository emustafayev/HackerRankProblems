package main

import "fmt"

func main() {

	// 1,3,2,4
	// 3,1,2,4

	fmt.Println(findThePrefixCommonArray([]int{1, 3, 2, 4}, []int{3, 1, 2, 4}))
	fmt.Println(findThePrefixCommonArray([]int{2, 3, 1}, []int{3, 1, 2}))

}

func findThePrefixCommonArray(A []int, B []int) []int {
	n := len(A)

	freqArr := make([]int, n+1)

	C := make([]int, n)

	common := 0

	for i := 0; i < n; i++ {
		freqArr[A[i]]++

		if freqArr[A[i]] == 2 {
			common++
		}

		freqArr[B[i]]++

		if freqArr[B[i]] == 2 {
			common++
		}
		C[i] = common

	}
	return C
}

func findThePrefixCommonArray2(A []int, B []int) []int {
	// 2657
	n := len(A)
	m := make(map[int]int, n) // A 1 B 2 AB 3
	rs, mAB := make([]int, n), make(map[int]struct{}, n)
	for i := 0; i < n; i++ {
		if vA, foundA := m[A[i]]; foundA {
			if vA == 2 {
				m[A[i]] = 3
				mAB[A[i]] = struct{}{}
			}
		} else {
			m[A[i]] = 1
		}
		if vB, foundB := m[B[i]]; foundB {
			if vB == 1 {
				m[B[i]] = 3
				mAB[B[i]] = struct{}{}
			}
		} else {
			m[B[i]] = 2
		}
		rs[i] = len(mAB)
	}
	return rs
}
