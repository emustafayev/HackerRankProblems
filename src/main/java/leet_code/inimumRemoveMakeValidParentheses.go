package main

func main() {
	minRemoveToMakeValid("lee)(t(g(h))code")
}

func minRemoveToMakeValid(s string) string {
	var firstTraversRes []byte
	countOpening := 0
	countClosing := 0
	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			countOpening++
		} else if s[i] == ')' {
			countClosing++
		}
		if countClosing > countOpening {
			countClosing--
		} else {
			firstTraversRes = append(firstTraversRes, s[i])
		}
	}
	var secondTraversRes []byte
	countOpening = 0
	countClosing = 0
	for i := len(firstTraversRes) - 1; i >= 0; i-- {
		if firstTraversRes[i] == ')' {
			countOpening++
		} else if firstTraversRes[i] == '(' {
			countClosing++
		}
		if countClosing > countOpening {
			countClosing--
		} else {
			secondTraversRes = append(secondTraversRes, firstTraversRes[i])
		}
	}
	res := ""
	for s := len(secondTraversRes) - 1; s >= 0; s-- {
		res += string(rune(secondTraversRes[s]))
	}
	return res
}
