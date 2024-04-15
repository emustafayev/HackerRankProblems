package main

import "fmt"

func main() {
	fmt.Println(isIsomorphic("egg", "add"))
	fmt.Println(isIsomorphic("foo", "bar"))
}

func isIsomorphic(s string, t string) bool {

	mp1 := make([]int, 128)
	mp2 := make([]int, 128)

	for i := 0; i < len(s); i++ {
		tCh := t[i]
		sCh := s[i]

		if mp1[sCh] == 0 && mp2[tCh] == 0 {
			mp1[sCh] = int(tCh)
			mp2[tCh] = int(sCh)
		} else if mp1[sCh] != int(tCh) || mp2[tCh] != int(sCh) {
			return false
		}
	}
	return true
}
