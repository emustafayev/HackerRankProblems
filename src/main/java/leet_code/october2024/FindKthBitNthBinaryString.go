package main

import "fmt"

func main() {
	fmt.Println(findKthBit(3, 1))
}

// Time Limit Ex
func findKthBit(n int, k int) byte {

	memo := make(map[int]string)
	res := _findKthBit(n, memo)
	fmt.Println(res)
	return res[k-1]
}

func _findKthBit(n int, memo map[int]string) string {
	if n == 1 {
		return "0"
	}
	if memo[n] != "" {
		return memo[n]
	}

	kThString := _findKthBit(n-1, memo)
	res := kThString + "1" + reverse(invert(kThString))
	memo[n] = res
	return res
}

func reverse(s string) string {
	res := ""
	for i := len(s) - 1; i >= 0; i-- {
		res = res + string(s[i])
	}
	return res
}

func invert(thString string) string {
	res := ""
	for i := 0; i < len(thString); i++ {
		currBit := thString[i]
		if currBit == '0' {
			res = res + "1"
		} else {
			res = res + "0"
		}
	}
	return res
}

func findKthBit2(n int, k int) byte {
	// Base case: When n = 1, the binary string is "0"
	if n == 1 {
		return '0'
	}

	// Find the length of the current string Sn, which is 2^n - 1
	length := (1 << n) - 1

	// Find the middle position
	mid := length/2 + 1

	// If k is the middle position, return '1'
	if k == mid {
		return '1'
	}

	// If k is in the first half, find the bit in Sn-1
	if k < mid {
		return findKthBit2(n-1, k)
	}

	// If k is in the second half, find the bit in Sn-1 and invert it
	if findKthBit2(n-1, length-k+1) == '0' {
		return '1'
	}
	return '0'
}
