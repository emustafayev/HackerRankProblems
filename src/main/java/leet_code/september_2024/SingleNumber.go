package main

func main() {

	nums := []int{2, 2, 11, 11, 3, 3, 4}
	res := singleNumber(nums)
	println(res)
	return
}

func singleNumber(nums []int) int {
	res := 0
	for _, num := range nums {
		res = res ^ num
	}
	return res
}
