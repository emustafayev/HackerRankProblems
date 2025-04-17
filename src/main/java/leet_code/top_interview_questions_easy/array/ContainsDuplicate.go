package main

func main() {

}

func containsDuplicate(nums []int) bool {

	m := map[int]bool{}

	for _, num := range nums {

		if m[num] {
			return true
		}
		m[num] = true

	}

	return false

}
