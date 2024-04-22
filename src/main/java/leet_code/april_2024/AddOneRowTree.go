package main

func main() {

	root := &TreeNode{
		4,
		&TreeNode{
			2,
			&TreeNode{3, nil, nil},
			&TreeNode{1, nil, nil},
		},
		&TreeNode{
			6,
			&TreeNode{5, nil, nil},
			nil,
		},
	}
	addOneRow(root, 1, 2)

}

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func addOneRow(root *TreeNode, val int, depth int) *TreeNode {
	if depth == 1 {
		newRoot := &TreeNode{Val: val}
		newRoot.Left = root
		return newRoot
	}
	return dfs(root, val, depth, 1)
}

func dfs(root *TreeNode, val, depth, currentDepth int) *TreeNode {
	if root == nil {
		return nil
	}

	if depth-1 == currentDepth {
		left := root.Left
		right := root.Right
		root.Left = &TreeNode{val, left, nil}
		root.Right = &TreeNode{val, nil, right}
		return root
	}

	root.Left = dfs(root.Left, val, depth, currentDepth+1)
	root.Right = dfs(root.Right, val, depth, currentDepth+1)

	return root
}
