package main

import "fmt"

func main() {

	fmt.Println(tribonacci(29))
}

func tribonacci(n int) int {

	mp := make(map[int]int)
	mp[0] = 0
	mp[1] = 1
	mp[2] = 1
	return tribbo(n, mp)
}

func tribbo(n int, mp map[int]int) int {

	if found, el := mp[n]; el {
		return found
	}

	res := tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3)
	mp[n] = res
	return res
}

func tribonacci2(n int) int {
	var res = [50]int{}
	res[0] = 0
	res[1] = 1
	res[2] = 1
	for i := 3; i <= n; i++ {
		res[i] = res[i-1] + res[i-2] + res[i-3]
	}
	return res[n]
}
