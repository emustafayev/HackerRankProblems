package main

func main() {

}

type treeNode3 struct {
	Val   int
	Left  *treeNode3
	Right *treeNode3
}

func isSymmetric(root *treeNode3) bool {

	return isMirror(root.Left, root.Right)
}

func isMirror(root1, root2 *treeNode3) bool {
	if root1 == nil && root2 == nil {
		return true
	}
	if root1 == nil || root2 == nil {
		return false
	}
	if root1.Val == root2.Val && isMirror(root1.Left, root2.Right) && isMirror(root1.Right, root2.Left) {
		return true
	}
	return false
}
