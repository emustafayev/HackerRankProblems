package main

func main() {

}

type treeNode struct {
	Val   int
	Left  *treeNode
	Right *treeNode
}

func maxDepth(root *treeNode) int {
	return traverse(root, 0)
}

func traverse(root *treeNode, depth int) int {
	if root == nil {
		return depth
	}
	return max(traverse(root.Left, depth+1), traverse(root.Right, depth+1))
}
