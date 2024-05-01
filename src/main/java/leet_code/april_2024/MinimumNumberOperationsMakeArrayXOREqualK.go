package main

import "fmt"

func main() {

	fmt.Println(minOperations2([]int{2, 1, 3, 4}, 1))

}

func minOperations(nums []int, k int) int {
	total := nums[0]
	for i := 1; i < len(nums); i++ {
		total ^= nums[i]
	}
	diff := 0
	for i := 0; i < 32; i++ {
		if nBit(total, i) != nBit(k, i) {
			diff++
		}
	}
	return diff
}

func nBit(num int, i int) int {
	return num >> i & 1 // move num's ith bit to the rightmost, and perform AND bitwise with 1; (0101) AND (0001) => (0001)
}

func minOperations2(nums []int, k int) int {
	arrayXor := 0
	for _, num := range nums {
		arrayXor ^= num
	}

	if arrayXor == k {
		return 0
	}

	xor := arrayXor ^ k
	flips := 0

	for xor != 0 {
		if xor&1 != 0 { // compare it with zero, because we extracted k before. So result should be (0000)
			flips++
		}
		xor = xor >> 1
	}

	return flips
}
