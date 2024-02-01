package main

import "fmt"

func main() {
	fmt.Println(knightDialer(3131))
}

var JUMPS = [][]int{
	{4, 6},
	{6, 8},
	{7, 9},
	{4, 8},
	{3, 9, 0},
	{},
	{1, 7, 0},
	{2, 6},
	{1, 3},
	{2, 4},
}

const MOD = int64(1e9) + 7

func knightDialer(n int) int {
	memory := make([][10]int64, n+1)
	var sum int64

	for nodeIndex := range JUMPS {
		sum = (sum + _knightDialer(n-1, nodeIndex, memory)) % MOD
	}
	return int(sum)
}

// DP
func _knightDialer(remain int, currentNode int, memory [][10]int64) int64 {
	if remain == 0 {
		return 1
	}
	if memory[remain][currentNode] != 0 {
		return memory[remain][currentNode]
	}
	var totalCombo int64
	for _, node := range JUMPS[currentNode] {
		totalCombo = (totalCombo + _knightDialer(remain-1, node, memory)) % MOD
	}
	memory[remain][currentNode] = totalCombo
	return totalCombo
}
