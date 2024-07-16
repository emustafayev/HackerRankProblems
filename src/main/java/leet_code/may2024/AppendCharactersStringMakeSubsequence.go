package main

import "fmt"

func main() {

	fmt.Println(appendCharacters("coaching", "coding"))
	fmt.Println(appendCharacters("a", "z"))
}

func appendCharacters(s string, t string) int {

	nS, nT, pT, pS := len(s), len(t), 0, 0
	for pS < nS && pT < nT {
		if s[pS] == t[pT] {
			pT++
		}
		pS++
	}
	return nT - pT
}
