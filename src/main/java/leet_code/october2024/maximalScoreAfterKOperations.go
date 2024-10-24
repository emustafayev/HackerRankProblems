package main

import (
	"container/heap"
	"math"
)

type MaxHeap []int64

func (h *MaxHeap) Push(x interface{}) {
	*h = append(*h, x.(int64))
}

func (h *MaxHeap) Pop() interface{} {

	old := *h

	x := old[len(old)-1]

	*h = old[0 : len(old)-1]

	return x
}

func (h MaxHeap) Len() int { return len(h) }
func (h MaxHeap) Swap(i, j int) {
	h[i], h[j] = h[j], h[i]
}
func (h MaxHeap) Less(i, j int) bool {
	return h[i] < h[j]
}

func maxKelements(nums []int, k int) int64 {
	pq := &MaxHeap{}
	heap.Init(pq)

	for _, num := range nums {
		heap.Push(pq, int64(num))
	}

	var res int64 = 0
	for i := 0; i < k; i++ {
		maxEl := heap.Pop(pq).(int64)
		res += maxEl
		heap.Push(pq, int64(math.Ceil(float64(maxEl)/3)))
	}
	return res
}
