package main

import (
	"fmt"
)

func main() {

	fmt.Println(countSeniors([]string{"7868190130M7522", "5303914400F9211", "9273338290F4010"}))

}

func countSeniors(details []string) int {

	counter := 0

	for _, detail := range details {
		extractedAge := detail[11:13]
		age := 10*(extractedAge[0]-'0') + extractedAge[1] - '0'

		//
		//age, err := strconv.Atoi(detail[11:13])
		//if err != nil {
		//	log.Fatal(err)
		//}

		if age > 60 {
			counter++
		}

	}

	return counter
}
