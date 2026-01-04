package main

func main() {

}

type Node struct {
	Data     int
	OutEdges []*Node
}

/*

1. Map node to index
2. Queue


*/

func Encode(root *Node) []int {
	var res []int

	m := make(map[*Node]int)
	queue := []*Node{root}
	index := 0

	for len(queue) > 0 {
		curr := queue[0]
		queue = queue[1:]
		if _, exists := m[curr]; !exists {
			m[curr] = index
			index++
			for _, out := range curr.OutEdges {
				queue = append(queue, out)
			}
		}
	}
	idToNode := make(map[int]*Node, index)

	for k, v := range m {
		idToNode[v] = k
	}

	return res
}
