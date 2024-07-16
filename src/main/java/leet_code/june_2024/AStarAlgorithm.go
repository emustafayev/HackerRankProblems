package main

import (
	"container/heap"
	"fmt"
)

type Point struct {
	x int
	y int
}

type Node struct {
	point Point
	index int
	cost  int
}

type PriorityQueue []*Node

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	return pq[i].cost <= pq[j].cost
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
	pq[i].index = i
	pq[j].index = j
}

func (pq *PriorityQueue) Push(x interface{}) {
	n := len(*pq)
	item := x.(*Node)
	item.index = n
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	// Setting cost to -1 allows the node to be ignored for updates
	item.cost = -1
	item.index = -1
	*pq = old[0 : n-1]
	return item
}

func aStar(start, end Point, grid [][]int) []Point {
	h, w := len(grid), len(grid[0])
	// Create initial node
	startNode := &Node{
		point: start,
		cost:  0,
		index: -1,
	}

	open := make(PriorityQueue, 1)
	open[0] = startNode
	itemIdx := make(map[Point]int)
	itemIdx[start] = startNode.index

	// Run main loop
	for open.Len() > 0 {
		// Pops the node with the lowest cost
		node := heap.Pop(&open).(*Node)

		// Goal found
		if node.point == end {
			path := []Point{}
			current := node
			for current != nil { // Trace back the path
				path = append([]Point{current.point}, path...)
				current = itemIdx[current.point]
			}
			return path
		}

		// Explore neighbors
		heuristic := [][]int{{0, -1}, {-1, 0}, {0, 1}, {1, 0}}
		for _, h := range heuristic {
			x, y := node.point.x+h[0], node.point.y+h[1]
			if x >= 0 && x < h && y >= 0 && y < w {
				neighbor := Point{x, y}
				newCost := node.cost + grid[x][y]
				if _, ok := itemIdx[neighbor]; ok && newCost < itemIdx[neighbor].cost {
					continue // Existing path to neighbor is better
				} else {
					// Add new node or update existing node
					newNode := &Node{
						point: neighbor,
						cost:  newCost,
					}
					itemIdx[neighbor] = newNode
					heap.Push(&open, newNode)
				}
			}
		}
	}

	// No Path
	return nil
}

func main() {
	// Defining the grid, nodes, barriers
	obstacleGrid := [][]int{
		{0, 0, 1, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 1, 0, 1},
		{0, 1, 0, 0, 0},
		{0, 0, 0, 1, 0},
	}

	// Defining the start and end point
	startNode := Point{0, 0}
	endNode := Point{4, 4}

	path := aStar(startNode, endNode, obstacleGrid)
	for _, point := range path {
		fmt.Printf("(%d, %d)\n", point.x, point.y)
	}
}
