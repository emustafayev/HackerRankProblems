package main

import (
	"fmt"
	"sort"
	"strconv"
)

func main() {

	findRelativeRanks([]int{5, 4, 9, 3, 1, 2})
}

func findRelativeRanks(score []int) []string {

	type kv struct {
		Key   int
		Value int
	}

	var scores []kv

	for k, v := range score {
		scores = append(scores, kv{k, v})
	}

	sort.Slice(scores, func(i, j int) bool {
		return scores[i].Value > scores[j].Value
	})

	mp := make(map[int]string, len(score))

	for i, pair := range scores {
		switch i {
		case 0:
			mp[pair.Key] = "Gold Medal"
		case 1:
			mp[pair.Key] = "Silver Medal"
		case 2:
			mp[pair.Key] = "Bronze Medal"
		default:
			mp[pair.Key] = strconv.Itoa(i + 1)
		}
	}

	var res []string

	for _, v := range mp {
		res = append(res, v)
	}
	fmt.Println(res)
	return res
}

func findRelativeRanks2(score []int) []string {
	var temp []int
	mp := map[int]int{}
	var ans []string

	temp = append(temp, score...)

	sort.Sort(sort.Reverse(sort.IntSlice(temp)))

	for i := range temp {
		mp[temp[i]] = i + 1
	}

	for i := range score {
		if mp[score[i]] == 1 {
			ans = append(ans, "Gold Medal")
		} else if mp[score[i]] == 2 {
			ans = append(ans, "Silver Medal")
		} else if mp[score[i]] == 3 {
			ans = append(ans, "Bronze Medal")
		} else {
			num := strconv.Itoa(mp[score[i]])
			ans = append(ans, num)
		}
	}

	return ans
}
