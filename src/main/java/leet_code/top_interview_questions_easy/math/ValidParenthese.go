package main

func main() {

}

func isValid(s string) bool {
	var stack []byte

	for i := 0; i < len(s); i++ {
		if s[i] == '(' || s[i] == '{' || s[i] == '[' {
			stack = append(stack, s[i])
		}

		if s[i] == ')' || s[i] == '}' || s[i] == ']' {
			if len(stack) == 0 {
				return false
			}
			if stack[len(stack)-1] == '(' && s[i] == ')' ||
				stack[len(stack)-1] == '{' && s[i] == '}' ||
				stack[len(stack)-1] == '[' && s[i] == ']' {
				stack = stack[:len(stack)-1]

			} else {
				return false
			}
		}
	}

	return len(stack) == 0
}
