package main

func main() {

}

type treeNode4 struct {
	Val   int
	Left  *treeNode4
	Right *treeNode4
}

func levelOrder(root *treeNode4) [][]int {

	res := [][]int{}

	if root == nil {
		return res
	}

	queue := []*treeNode4{root}

	for len(queue) > 0 {
		level := []int{}
		lq := len(queue)
		for i := 0; i < lq; i++ {
			current := queue[0]
			queue = queue[1:]
			level = append(level, current.Val)
			if current.Left != nil {
				queue = append(queue, current.Left)
			}
			if current.Right != nil {
				queue = append(queue, current.Right)
			}
		}
		res = append(res, level)
	}
	return res
}
