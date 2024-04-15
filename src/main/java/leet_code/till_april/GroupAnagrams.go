package main

import (
	"fmt"
	"strconv"
)

func main() {

	fmt.Println(groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))

}

type Anagram struct {
	Signature string
	Bulk      []string
}

type AnagramList []Anagram

func (a AnagramList) Get(s string) *Anagram {
	signature := getSignature(s)
	for i, anagram := range a {
		if anagram.Signature == signature {
			return &a[i]
		}
	}
	return nil
}

func getSignature(s string) string {
	countTable := make([]int, 26)
	for _, el := range s {
		countTable[el-'a']++
	}
	res := ""
	for i, el := range countTable {
		if el != 0 {
			res += string(rune('a'+i)) + strconv.Itoa(el)
		}
	}
	return res
}

func groupAnagrams(strs []string) [][]string {

	anagramList := AnagramList{}
	for _, s := range strs {
		if anagram := anagramList.Get(s); anagram != nil {
			anagram.Bulk = append(anagram.Bulk, s)
		} else {
			anagramList = append(anagramList, Anagram{getSignature(s), []string{s}})
		}
	}

	res := [][]string{}
	for _, el := range anagramList {
		res = append(res, el.Bulk)
	}

	return res
}

func groupAnagrams2(strs []string) [][]string {
	var ans [][]string
	ana := make(map[[26]int][]string)

	for _, s := range strs {
		var cnt [26]int
		for _, c := range s {
			cnt[c-'a']++
		}
		ana[cnt] = append(ana[cnt], s)
	}
	for _, v := range ana {
		ans = append(ans, v)
	}
	return ans
}
