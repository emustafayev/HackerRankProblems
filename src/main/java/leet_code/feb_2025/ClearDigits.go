package main

import "fmt"

func main() {

	fmt.Println(clearDigits("a1b2c3d4e5"))
	fmt.Println(clearDigits("acb2c3dge5"))
	fmt.Println(clearDigits("cb34"))

}
func clearDigits(s string) string {
	result := ""
	for i := 0; i < len(s); i++ {
		ch := s[i]
		if ch >= '0' && ch <= '9' {
			result = result[:len(result)-1]
		} else {
			result = result + string(ch)
		}
	}
	return result
}
