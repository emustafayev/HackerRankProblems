package main

import "fmt"

func main() {

}

func replaceValueInTree(root *TreeNode) *TreeNode {

	var dfsSum func(root *TreeNode, sums map[int]int, level int)

	dfsSum = func(root *TreeNode, sums map[int]int, level int) {

		if root == nil {
			return
		}
		sums[level] += root.Val
		dfsSum(root.Left, sums, level+1)
		dfsSum(root.Right, sums, level+1)
	}

	sums := make(map[int]int)

	dfsSum(root, sums, 0)

	fmt.Println(sums)

	var dfsCalc func(root *TreeNode, sums map[int]int, level, val int)

	dfsCalc = func(root *TreeNode, sums map[int]int, val, level int) {
		if root == nil {
			return
		}

		root.Val = val

		levelSum := sums[level]
		if root.Left != nil {
			levelSum -= root.Left.Val
		}
		if root.Right != nil {
			levelSum -= root.Right.Val
		}

		dfsCalc(root.Left, sums, levelSum, level+1)
		dfsCalc(root.Right, sums, levelSum, level+1)

	}

	dfsCalc(root, sums, 0, 0)

	return root

}

// depthSum is now a package-level variable
var depthSum []int

// dfs1 performs the first DFS to calculate the sum of node values at each depth
func dfs1(root *TreeNode, d int) {
	if root == nil {
		return // Base case: if the node is null, return
	}

	// If the current depth is greater than or equal to the slice length,
	// add a new element with the current node's value
	if d >= len(depthSum) {
		depthSum = append(depthSum, root.Val)
	} else {
		// Otherwise, add the current node's value to the existing sum at this depth
		depthSum[d] += root.Val
	}

	// Recursively call dfs1 for left and right children, incrementing the depth
	dfs1(root.Left, d+1)
	dfs1(root.Right, d+1)
}

// dfs2 performs the second DFS to replace node values
func dfs2(root *TreeNode, val int, d int) {
	if root == nil {
		return // Base case: if the node is null, return
	}

	// Replace the current node's value with the passed 'val'
	root.Val = val

	// Calculate the sum of cousin nodes' values
	// If there's a next depth, get its sum, otherwise use 0
	c := 0
	if d+1 < len(depthSum) {
		c = depthSum[d+1]
	}
	// Subtract the values of the current node's children (if they exist)
	if root.Left != nil {
		c -= root.Left.Val
	}
	if root.Right != nil {
		c -= root.Right.Val
	}

	// Recursively call dfs2 for left and right children
	// Pass the calculated cousin sum 'c' and increment the depth
	if root.Left != nil {
		dfs2(root.Left, c, d+1)
	}
	if root.Right != nil {
		dfs2(root.Right, c, d+1)
	}
}

// replaceValueInTree is the main function to replace values in the tree
func replaceValueInTree2(root *TreeNode) *TreeNode {
	depthSum = []int{} // Initialize depthSum slice
	// First DFS to calculate depth sums
	dfs1(root, 0)
	// Second DFS to replace values, starting with 0 for the root
	dfs2(root, 0, 0)
	// Return the modified root
	return root
}
