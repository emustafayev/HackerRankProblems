package main

import "fmt"

func main() {

	//0001
	//0010  => OR
	//0100
	//----
	//0111  => 7
	fmt.Println(countMaxOrSubsets([]int{1, 2, 4}))
	fmt.Println(countMaxOrSubsets([]int{1, 3}))
	fmt.Println(countMaxOrSubsets([]int{2, 2, 2}))
	fmt.Println(countMaxOrSubsets([]int{3, 2, 1, 5}))

}

func countMaxOrSubsets(nums []int) int {
	maxOr := 0

	for _, num := range nums {
		maxOr |= num
	}
	count := 0
	backtrack(nums, 0, 0, maxOr, &count)
	return count
}

//

func backtrack(nums []int, index, currentOr, maxOr int, counter *int) {

	if currentOr == maxOr {
		*counter++
	}

	for i := index; i < len(nums); i++ {
		backtrack(nums, i+1, currentOr|nums[i], maxOr, counter)
	}

}
