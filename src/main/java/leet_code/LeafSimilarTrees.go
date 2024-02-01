package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {

	var l1 []int

	var l2 []int

	dfs(&l1, root1)
	dfs(&l2, root2)
	return testEq(l1, l2)
}

func dfs(l *[]int, root *TreeNode) {

	if root != nil {
		if root.Left == nil && root.Right == nil {
			*l = append(*l, root.Val)
		}
	}

	dfs(l, root.Left)
	dfs(l, root.Right)

}

func testEq(a, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}
	return true
}
