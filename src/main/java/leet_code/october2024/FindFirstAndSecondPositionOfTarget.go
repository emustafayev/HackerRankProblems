package main

import "fmt"

func main() {

	fmt.Println(searchRange([]int{5, 7, 7, 8, 8, 10}, 8))
	fmt.Println(searchRange([]int{5, 7, 7, 8, 8, 10}, 6))
	fmt.Println(searchRange([]int{}, 6))
	fmt.Println(searchRange([]int{1}, 1))
}

func searchRange(nums []int, target int) []int {
	left := 0
	right := len(nums) - 1
	result := []int{-1, -1}

	if len(nums) == 0 {
		return result
	}

	for {
		if left > right {
			break
		}
		mid := left + (right-left)/2
		if nums[mid] == target {
			i1 := mid
			i2 := mid
			for i1 >= 0 && nums[i1] == target {
				i1--
			}
			for i2 < len(nums) && nums[i2] == target {
				i2++
			}
			result = []int{i1 + 1, i2 - 1}
			break
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}

	return result

}
