package main

import (
	"fmt"
	"sort"
	"strings"
)

func main() {
	fmt.Println(frequencySort("tree")) // time limit exception
}

type Pair struct {
	Key   string
	Value int
}

type PairList []Pair

func (p PairList) Len() int           { return len(p) }
func (p PairList) Swap(i, j int)      { p[i], p[j] = p[j], p[i] }
func (p PairList) Less(i, j int) bool { return p[i].Value > p[j].Value }

func (p PairList) Get(key string) *Pair {
	for index, pair := range p {
		if pair.Key == key {
			return &p[index]
		}
	}
	return nil
}

func frequencySort(s string) string {
	freqPair := make(PairList, len(s))
	for _, ch := range s {
		pair := freqPair.Get(string(ch))

		if pair != nil {
			pair.Value = pair.Value + 1
		} else {
			freqPair = append(freqPair, Pair{Key: string(ch), Value: 1})
		}
	}

	sort.Sort(freqPair)

	res := ""
	for _, p := range freqPair {
		if p.Value > 0 {
			res += strings.Repeat(p.Key, p.Value)
		}
	}

	return res
}
