package main

func main() {

	var n int = 2
	var result int = climbStairs(n)
	println(result)
}

func climbStairs(n int) int {

	m := make(map[int]int)

	return climb(0, n, m)
}

func climb(s, n int, memo map[int]int) int {
	if s == n {
		return 1
	}
	if s > n {
		return 0
	}

	if val, exists := memo[s]; exists {
		return val
	}

	res := climb(s+1, n, memo) + climb(s+2, n, memo)
	memo[s] = res

	return res
}
