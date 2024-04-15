package main

import (
	"fmt"
	"sort"
	"strings"
)

func main() {

	fmt.Println(frequencySort2("cccaaa"))
	fmt.Println(frequencySort2("Aabb"))
	fmt.Println(frequencySort2("tree"))
}

type Pair2 struct {
	Key   string
	Value int
}

type PairList2 []Pair2

func (p PairList2) Len() int {
	return len(p)
}

func (p PairList2) Swap(i, j int) {
	p[i], p[j] = p[j], p[i]
}

func (p PairList2) Less(i, j int) bool { return p[i].Value > p[j].Value }

func (p PairList2) Get(key string) *Pair2 {
	for index, el := range p {
		if el.Key == key {
			return &p[index]
		}
	}
	return nil
}

func frequencySort2(s string) string {

	freqPair := PairList2{}

	for _, ch := range s {

		if pair := freqPair.Get(string(ch)); pair != nil {
			pair.Value = pair.Value + 1
		} else {
			freqPair = append(freqPair, Pair2{string(ch), 1})
		}
	}

	sort.Sort(freqPair)

	res := ""

	for _, el := range freqPair {
		res = res + strings.Repeat(el.Key, el.Value)
	}

	return res
}
