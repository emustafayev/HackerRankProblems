package main

import (
	"fmt"
	"strings"
)

func main() {
	//fmt.Println(customSortString("cba", "abcd"))
	//fmt.Println(customSortString("bcafg", "abcd"))
	fmt.Println(customSortString("kqep", "pkldefkeqf"))

}

func customSortString(order string, s string) string {

	res := ""

	m := make(map[int32]int)

	for _, ch := range order {
		m[ch] = 0
	}

	for _, ch := range s {
		if count, found := m[ch]; found {
			m[ch] = count + 1
		}
	}

	for _, ch := range order {
		if m[ch] > 0 {
			res += strings.Repeat(string(ch), m[ch])
		}
	}

	for _, ch := range s {
		if !exists(ch, order) {
			res += string(ch)
		}
	}

	fmt.Println(res)

	fmt.Println(m)

	return res
}

func exists(find int32, s string) bool {
	for _, ch := range s {
		if ch == find {
			return true
		}
	}
	return false
}

func customSortString2(order string, s string) string {
	m := map[byte]int{}

	for i := range s {
		m[s[i]] += 1
	}

	res := make([]byte, 0, len(s))

	for i := range order {
		if val, ok := m[order[i]]; ok {
			for j := 0; j < val; j++ {
				res = append(res, order[i])
			}

			delete(m, order[i])
		}
	}

	for k, v := range m {
		for j := 0; j < v; j++ {
			res = append(res, k)
		}
	}

	return string(res)
}
