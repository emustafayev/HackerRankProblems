package main

import "fmt"

import (
	"container/heap"
)

func main() {
	fmt.Println(maxAverageRatio([][]int{{1, 2}, {3, 4}}, 1))
	fmt.Println(maxAverageRatio([][]int{{1, 2}, {3, 5}, {2, 2}}, 2))
	fmt.Println(maxAverageRatio([][]int{{2, 4}, {3, 9}, {4, 5}, {2, 10}}, 4))

}

func maxAverageRatio(classes [][]int, extraStudents int) float64 {
	// Initial pass ratios for all classe
	passRations := make([]float64, 0)
	for _, class := range classes {
		passRations = append(passRations, float64(class[0])/float64(class[1]))
	}

	for extraStudents > 0 {

		// Calculate new ratios for each class if an extra student is added
		newRations := make([]float64, 0)
		for _, class := range classes {
			newRations = append(newRations, float64(class[0]+1)/float64(class[1]+1))
		}

		bestIndex := 0
		bestRatio := 0.0

		for i := 0; i < len(classes); i++ {
			gain := newRations[i] - passRations[i]

			if gain > bestRatio {
				bestIndex = i
				bestRatio = gain
			}
		}
		passRations[bestIndex] = newRations[bestIndex]
		classes[bestIndex][0]++
		classes[bestIndex][1]++

		extraStudents--

	}

	finalRatio := 0.0

	for _, ratio := range passRations {
		finalRatio += ratio
	}
	return finalRatio / float64(len(passRations))
}

func maxAverageRatio2(classes [][]int, extraStudents int) float64 {
	h := &MaxHeap{}
	heap.Init(h)

	for _, class := range classes {
		pass, total := class[0], class[1]
		diff := float64(pass+1)/float64(total+1) - float64(pass)/float64(total)
		heap.Push(h, []float64{diff, float64(pass), float64(total)})
	}

	for extraStudents > 0 {
		top := heap.Pop(h).([]float64)
		pass, total := top[1]+1, top[2]+1
		diff := float64(pass+1)/float64(total+1) - float64(pass)/float64(total)
		heap.Push(h, []float64{diff, pass, total})
		extraStudents--
	}

	var sum float64
	for h.Len() > 0 {
		top := heap.Pop(h).([]float64)
		sum += top[1] / top[2]
	}
	return sum / float64(len(classes))
}

type MaxHeap [][]float64

func (h MaxHeap) Len() int            { return len(h) }
func (h MaxHeap) Less(i, j int) bool  { return h[i][0] > h[j][0] }
func (h MaxHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *MaxHeap) Push(x interface{}) { *h = append(*h, x.([]float64)) }
func (h *MaxHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[:n-1]
	return x
}
