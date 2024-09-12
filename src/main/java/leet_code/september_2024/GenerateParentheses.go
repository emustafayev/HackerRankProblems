package main

import "fmt"

func main() {

	fmt.Println(generateParenthesis(60))
}

func generateParenthesis(n int) []string {

	var res []string

	_generate(&res, 0, 0, "", n)

	return res

}

func _generate(res *[]string, left, right int, str string, n int) {
	if len(str) == 2*n {
		*res = append(*res, str)
		return
	}

	if left < n {
		_generate(res, left+1, right, str+"(", n)
	}

	if right < left {
		_generate(res, left, right+1, str+")", n)
	}
}
