package main

import (
	"container/heap"
	"fmt"
	"strings"
)

func main() {

	fmt.Println(longestDiverseString(1, 2, 5))
}

type CharCount struct {
	count int
	ch    byte
}

// Priority queue implementation for Go
type MaxHeap2 []CharCount

func (h MaxHeap2) Len() int           { return len(h) }
func (h MaxHeap2) Less(i, j int) bool { return h[i].count > h[j].count }
func (h MaxHeap2) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MaxHeap2) Push(x interface{}) {
	*h = append(*h, x.(CharCount))
}

func (h *MaxHeap2) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

func longestDiverseString(a, b, c int) string {
	pq := &MaxHeap2{}
	heap.Init(pq)
	if a > 0 {
		heap.Push(pq, CharCount{count: a, ch: 'a'})
	}
	if b > 0 {
		heap.Push(pq, CharCount{count: b, ch: 'b'})
	}
	if c > 0 {
		heap.Push(pq, CharCount{count: c, ch: 'c'})
	}

	result := strings.Builder{}

	for pq.Len() > 0 {

		first := heap.Pop(pq).(CharCount)

		if result.Len() >= 2 && first.ch == result.String()[result.Len()-1] &&
			first.ch == result.String()[result.Len()-2] {

			if pq.Len() == 0 {
				break
			}

			second := heap.Pop(pq).(CharCount)

			result.WriteByte(second.ch)
			second.count--
			if second.count > 0 {
				heap.Push(pq, second)
			}
			heap.Push(pq, first)
		} else {
			result.WriteByte(first.ch)
			first.count--
			if first.count > 0 {
				heap.Push(pq, first)
			}
		}
	}

	return result.String()
}
