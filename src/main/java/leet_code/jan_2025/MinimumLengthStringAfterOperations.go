package main

func main() {

}

func minimumLength(s string) int {

	if len(s) < 3 {
		return len(s)
	}

	chars := make(map[rune]int)

	for _, letter := range s {
		chars[letter]++
	}

	res := 0
	for _, count := range chars {
		res += 2 - count%2
	}

	return res
}
