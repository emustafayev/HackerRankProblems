package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	nums := []int{1, 2, 3}
	solution := Constructor2(nums)

	fmt.Println("Original:", nums)
	fmt.Println("Shuffle:", solution.Shuffle())
	fmt.Println("Reset:", solution.Reset())
	fmt.Println("Shuffle again:", solution.Shuffle())
}

type Solution struct {
	original []int
	current  []int
	rng      *rand.Rand
}

func Constructor2(nums []int) Solution {
	cpy := make([]int, len(nums))
	original := make([]int, len(nums))

	// Create a seed based on current time for better randomness
	source := rand.NewSource(time.Now().UnixNano())
	rng := rand.New(source)

	copy(cpy, nums)
	copy(original, nums)

	return Solution{
		original: original,
		current:  cpy,
		rng:      rng,
	}
}

func (this *Solution) Reset() []int {
	// Make a fresh copy from original
	copy(this.current, this.original)
	return this.current
}

func (this *Solution) Shuffle() []int {
	// Implement Fisher-Yates (Knuth) shuffle
	for i := len(this.current) - 1; i > 0; i-- {
		// Pick a random index from 0 to i
		j := this.rng.Intn(i + 1)

		// Swap elements at positions i and j
		this.current[i], this.current[j] = this.current[j], this.current[i]
	}
	return this.current
}

/**
 * Your Solution object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.Reset();
 * param_2 := obj.Shuffle();
 */
