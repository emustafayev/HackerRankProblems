package main

func main() {

}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func removeLeafNodes(root *TreeNode, target int) *TreeNode {
	if root == nil {
		return nil
	}

	root.Left = removeLeafNodes(root.Left, target)
	root.Right = removeLeafNodes(root.Right, target)

	if root.Left == nil && root.Right == nil && root.Val == target {
		return nil
	}

	return root
}

func removeLeafNodes2(root *TreeNode, target int) *TreeNode {
	if root == nil {
		return root
	}
	if root.Left != nil {
		root.Left = removeLeafNodes(root.Left, target)
	}
	if root.Right != nil {
		root.Right = removeLeafNodes(root.Right, target)
	}
	if root.Val == target && root.Left == nil && root.Right == nil {
		root = nil
		return root
	}
	return root
}
