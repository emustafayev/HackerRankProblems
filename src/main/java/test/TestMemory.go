package main

import "fmt"

func main() {

	var a = 23

	var b = &a

	fmt.Println(b)

	test(*b)
	fmt.Println(*b)

}

func test(b int) {
	fmt.Println(&b)

	b = 5
}
