package main

import "fmt"

func main() {
	fmt.Println(removeOccurrences("daabcbaabcbc", "abc"))
	fmt.Println(removeOccurrences("axxxxyyyyb", "xy"))
}

func removeOccurrences(s string, part string) string {

	stack := make([]rune, 0)

	for _, ch := range s {
		stack = append(stack, ch)

		if stack[len(stack)-1] == rune(part[len(part)-1]) {

			if len(stack) >= len(part) {
				matched := true
				for i := 0; i < len(part); i++ {
					if stack[len(stack)-i-1] == rune(part[len(part)-i-1]) {
						continue
					} else {
						matched = false
						break

					}
				}

				if matched {
					stack = stack[:len(stack)-len(part)]
				}
			}

		}

	}

	return string(stack)
}
