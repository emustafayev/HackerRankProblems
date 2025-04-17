package main

type treeNode5 struct {
	Val   int
	Left  *treeNode5
	Right *treeNode5
}

func main() {

}

func sortedArrayToBST(nums []int) *treeNode5 {
	n := len(nums)

	if n <= 0 {
		return nil
	}

	i := n / 2
	node := &treeNode5{Val: nums[i]}
	node.Left = sortedArrayToBST(nums[:i])
	node.Right = sortedArrayToBST(nums[i+1:])
	return node
}
