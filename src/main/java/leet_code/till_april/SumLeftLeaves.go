package main

func main() {

}

func sumOfLeftLeaves(root *TreeNode) int {
	return dfsSL(root, false)
}

func dfsSL(root *TreeNode, isLeft bool) int {

	if root.Left == nil && root.Right == nil && isLeft {
		return root.Val
	}

	sum := 0

	if root.Left != nil {
		sum += dfsSL(root.Left, true)
	}

	if root.Right != nil {
		sum += dfsSL(root.Right, false)
	}
	return sum
}

func sumOfLeftLeaves2(root *TreeNode) int {
	res := 0
	var dfs func(*TreeNode, bool)
	dfs = func(node *TreeNode, flag bool) {
		if node == nil {
			return
		}
		if node.Left == nil && node.Right == nil && flag {
			res += node.Val
		}
		dfs(node.Left, true)
		dfs(node.Right, false)
	}
	dfs(root, false)
	return res
}
