package main

import "fmt"

func main() {

	roo := TreeNodeL{
		Right: &TreeNodeL{Val: 3},
		Left:  &TreeNodeL{Val: 2},
		Val:   1,
	}
	fmt.Println(sumNumbers(&roo))
	fmt.Println(sumNumbers2(&roo))

}

/**
* Definition for a binary tree node.
 type TreeNode struct {
     Val int
     Left *TreeNode
     Right *TreeNode
 }
*/

type TreeNodeL struct {
	Val   int
	Left  *TreeNodeL
	Right *TreeNodeL
}

func sumNumbers(root *TreeNodeL) int {
	var numbers []int
	dfsL(root, 0, &numbers)
	sum := 0
	fmt.Println(numbers)
	for _, el := range numbers {
		sum += el
	}
	return sum
}

func dfsL(root *TreeNodeL, currNumber int, numbers *[]int) {

	if root == nil {
		return
	}
	if root.Left == nil && root.Right == nil {
		currNumber = currNumber*10 + root.Val
		*numbers = append(*numbers, currNumber)
		return
	}
	currNumber = currNumber*10 + root.Val
	dfsL(root.Left, currNumber, numbers)
	dfsL(root.Right, currNumber, numbers)
}

func sumNumbers2(root *TreeNodeL) int {
	return dfsL2(root, 0)

}

func dfsL2(root *TreeNodeL, currNumber int) int {

	if root.Left == nil && root.Right == nil {
		return currNumber*10 + root.Val
	}

	sum := 0
	if root.Left != nil {
		sum += dfsL2(root.Left, currNumber*10+root.Val)
	}

	if root.Right != nil {
		sum += dfsL2(root.Right, currNumber*10+root.Val)
	}
	return sum
}
