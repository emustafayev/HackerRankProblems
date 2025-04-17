package main

func main() {

}

type treeNode2 struct {
	Val   int
	Left  *treeNode2
	Right *treeNode2
}

func isValidBST(root *treeNode2) bool {
	var maxInt = int(^uint(0) >> 1) // Maximum int value
	var minInt = -maxInt - 1        // Minimum int value
	return valid(root, minInt, maxInt)
}

func valid(root *treeNode2, min int, max int) bool {
	if root == nil {
		return true
	}

	if min < root.Val && root.Val < max {
		return valid(root.Left, min, root.Val) && valid(root.Right, root.Val, max)
	} else {
		return false
	}
}
