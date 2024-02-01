package main

func main() {

}

// Weight Left
// Weights for each element
// Value of elements(profit)
// Count of the elements
func _knapsack(W int, WT, VAL []int, n int) int {

	if n == 0 || W <= 0 {
		return 0
	}

	//Take Current Element
	if WT[n-1] > W { //Element weight too much. Cant take. Move to the next element(n-1)
		return _knapsack(W, WT, VAL, n-1)
	} else {
		return max(
			VAL[n-1]+_knapsack(W-WT[n-1], WT, VAL, n-1), // Take Element
			_knapsack(W, WT, VAL, n-1),                  // Not take
		)
	}

}

func max(a, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}
