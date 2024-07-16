package main

import "fmt"

func main() {

	fmt.Println(checkRecord(2))
	//fmt.Println(checkRecord(10101))
	fmt.Println(checkRecord(1))
}

func checkRecord(n int) int {

	return checker(n, []byte{'X', 'X', 'X'})

}

func checker(n int, prev3 []byte) int {
	if n == 0 {
		return 1
	}

	currPerm := 0

	//P case => present
	currPerm += checker(n-1, append(prev3, 'P')[1:])

	//A case
	if prev3[len(prev3)-1] != 'A' || (prev3[len(prev3)-1] == 'A' && prev3[len(prev3)-2] == 'A') {
		currPerm += checker(n-1, append(prev3, 'A')[1:])
	}

	//L case
	lC := 0
	for _, el := range prev3 {
		if el == 'L' {
			lC++
		}
	}

	if lC != 3 {
		currPerm += checker(n-1, append(prev3, 'L')[1:])
	}

	//Add three cases
	return currPerm
}
