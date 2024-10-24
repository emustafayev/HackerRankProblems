package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Println(maximumSwap(2736))
}

func maximumSwap(num int) int {

	numStr := []rune(fmt.Sprint(num))

	lastOccur := make([]int, 10)

	for i := 0; i < len(numStr); i++ {
		lastOccur[numStr[i]-'0'] = i
	}

	for i := 0; i < len(numStr); i++ {

		currentNum := int(numStr[i] - '0')

		currentNumIndex := i

		for j := 9; j > currentNum; j-- {

			//default value is 0, so we wouldn't need to recheck if digit exists.
			if lastOccur[j] > currentNumIndex {
				numStr[currentNumIndex], numStr[lastOccur[j]] = numStr[lastOccur[j]], numStr[currentNumIndex]
				res, _ := strconv.Atoi(string(numStr))
				return res
			}

		}

	}

	return num

}
