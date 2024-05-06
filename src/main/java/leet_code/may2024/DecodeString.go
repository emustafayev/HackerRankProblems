package main

import (
	"fmt"
)

func main() {

	fmt.Println(decodeString("3[a]2[bc]"))
}

type item struct {
	n     int
	bytes []byte
}

func decodeString(str string) string {
	num := 0
	st := []item{{1, []byte{}}}

	for i := range str {
		switch {
		case str[i] == '0':
			num *= 10
		case str[i] > '0' && str[i] <= '9':
			num = num*10 + int(str[i]-'0')
		case str[i] == '[':
			st = append(st, item{num, []byte{}})
			num = 0
		case str[i] == ']':
			tmp := st[len(st)-1]
			st = st[:len(st)-1]
			for j := 0; j < tmp.n; j++ {
				st[len(st)-1].bytes = append(st[len(st)-1].bytes, tmp.bytes...)
			}
		default:
			st[len(st)-1].bytes = append(st[len(st)-1].bytes, str[i])
		}
	}

	return string(st[0].bytes)
}
