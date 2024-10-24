package main

func main() {
	flipEquiv(nil, nil)

}
func flipEquiv(root1 *TreeNode, root2 *TreeNode) bool {

	var dfs func(root1, root2 *TreeNode) bool

	dfs = func(root1, root2 *TreeNode) bool {

		//if both note null, return true

		if root1 == nil && root2 == nil {
			return true
		}

		if root1 == nil || root2 == nil {
			return false
		}

		return (root1.Val == root2.Val) &&
			((dfs(root1.Left, root2.Left) && dfs(root1.Right, root2.Right)) ||
				(dfs(root1.Left, root2.Right) && dfs(root1.Right, root2.Left)))

	}

	return dfs(root1, root2)
}

func flipEquiv2(root1 *TreeNode, root2 *TreeNode) bool {
	if root1 == nil && root2 == nil {
		return true
	}
	if root1 == nil || root2 == nil {
		return false
	}
	if root1.Val != root2.Val {
		return false
	}
	r1l := -1
	r1r := -1
	r2l := -1
	r2r := -1
	if root1.Left != nil {
		r1l = root1.Left.Val
	}
	if root1.Right != nil {
		r1r = root1.Right.Val
	}
	if root2.Left != nil {
		r2l = root2.Left.Val
	}
	if root2.Right != nil {
		r2r = root2.Right.Val
	}
	if r1l == r2l && r1r == r2r {
		return flipEquiv2(root1.Left, root2.Left) &&
			flipEquiv2(root1.Right, root2.Right)
	} else if r1l == r2r && r2l == r1r {
		return flipEquiv2(root1.Left, root2.Right) &&
			flipEquiv2(root1.Right, root2.Left)
	}
	// fmt.Println(root1.Val)
	return false
}
