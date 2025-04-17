package main

import (
	"fmt"
	"sort"
)

func main() {

	fmt.Println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}

func groupAnagrams(strs []string) [][]string {
	group := make(map[string][]string)
	for i := 0; i < len(strs); i++ {
		current := []rune(strs[i])
		sort.Slice(current, func(i, j int) bool {
			return current[i] < current[j]
		})
		var key string
		for _, el := range current {
			key += string(el)
		}
		if _, found := group[key]; found {
			group[key] = append(group[key], strs[i])
		} else {
			group[key] = []string{strs[i]}
		}
	}

	var res [][]string
	for _, val := range group {
		res = append(res, val)
	}

	return res
}

func groupAnagrams2(strs []string) [][]string {
	hash := make(map[int64][]string)
	for _, value := range strs {
		h := weakHash(value)
		hash[h] = append(hash[h], value)
	}
	result := make([][]string, 0)
	for _, value := range hash {
		result = append(result, value)
	}
	return result
}

func weakHash(s string) int64 {
	var h int64
	for _, value := range s {
		h += int64(value) * int64(value) * int64(value) * int64(value)
	}
	return h
}
