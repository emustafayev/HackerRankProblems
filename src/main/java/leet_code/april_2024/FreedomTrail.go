package main

import "math"

func main() {
	findRotateSteps("godding", "gd")
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func findRotateSteps(ring string, key string) int {

	ringLen, keyLen := len(ring), len(key)

	var pos = make(map[uint8][]int, ringLen)

	for i := 0; i < ringLen; i++ {
		pos[ring[i]] = append(pos[ring[i]], i)
	}

	var memo = make([][]int, ringLen)

	for i := 0; i < ringLen; i++ {
		memo[i] = make([]int, keyLen)
		for j := 0; j < keyLen; j++ {
			memo[i][j] = -1
		}
	}

	var dfs func(i, j int) (res int)

	dfs = func(i, j int) (res int) {
		if j == keyLen {
			return 0
		}

		p := &memo[i][j]

		if *p != -1 {
			res = *p
			return
		}

		defer func() { *p = res }()

		res = math.MaxInt
		for _, ps := range pos[key[j]] {

			res = min(res, dfs(ps, j+1)+min(abs(ps-i), ringLen-abs(ps-i)))
		}
		return
	}
	return keyLen + dfs(0, 0)
}

func findRotateSteps2(ring string, key string) int {
	dict := make(map[byte][]int)
	for i := range ring {
		dict[ring[i]] = append(dict[ring[i]], i)
	}

	memo := make([][]int, len(ring))
	for i := range memo {
		memo[i] = make([]int, len(key))
		for j := range memo[i] {
			memo[i][j] = -1
		}
	}

	var dfs func(i, j int) int
	dfs = func(i, j int) int {
		if j == len(key) {
			return 0
		}
		if memo[i][j] != -1 {
			return memo[i][j]
		}
		res := math.MaxInt
		for _, pos := range dict[key[j]] {
			curr := 0
			if i >= pos {
				curr = min(i-pos, len(ring)+pos-i)
			} else {
				curr = min(pos-i, len(ring)+i-pos)
			}
			res = min(res, curr+dfs(pos, j+1))
		}
		memo[i][j] = res
		return res
	}
	return len(key) + dfs(0, 0)
}
