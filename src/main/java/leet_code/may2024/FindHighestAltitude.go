package main

func main() {

}

func largestAltitude(gain []int) int {
	res := 0
	runningSum := 0
	for _, el := range gain {
		runningSum += el
		res = max(runningSum, res)
	}
	return res
}
