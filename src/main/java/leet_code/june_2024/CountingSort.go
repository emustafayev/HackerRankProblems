package main

import "fmt"

func main() {
	res := sortArrayC([]int{4, 6, 2, 2, 9, 5, 5, 7, 7})

	fmt.Println(res)

}

func sortArrayC(ints []int) interface{} {

	max := 0

	for _, el := range ints {
		if max < el {
			max = el
		}
	}

	countArray := make([]int, max+1)

	for _, el := range ints {
		countArray[el]++
	}

	//cumulative sum for determining how many element present before current element
	for i := 1; i < len(countArray); i++ {
		countArray[i] += countArray[i-1]
	}

	output := make([]int, len(ints))

	//Find element position in count array(countArray[ints[i]]) and -1 for index
	//decreasing because we put the same element and we need to place other element before it
	for i := 0; i < len(output); i++ {
		output[countArray[ints[i]]-1] = ints[i]
		countArray[ints[i]]--
	}

	return output
}
