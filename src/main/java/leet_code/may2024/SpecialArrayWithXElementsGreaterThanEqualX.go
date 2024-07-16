package main

func main() {

}

func specialArray(nums []int) int {
	countMap := map[int]int{}
	for _, v := range nums {
		countMap[v] += 1
	}
	ans := -1
	for i := 1; i <= len(nums); i++ {
		count := 0
		for key, val := range countMap {
			if key >= i {
				count += val
			}
		}
		if count == i {
			ans = i
		}
	}
	return ans
}
