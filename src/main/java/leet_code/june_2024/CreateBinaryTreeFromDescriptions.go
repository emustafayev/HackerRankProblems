package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func createBinaryTree(descriptions [][]int) *TreeNode {

	mp := make(map[int][]int)

	var childList []int

	for _, desc := range descriptions {

		child := desc[1]
		parent := desc[0]
		isLeft := desc[2]

		if _, found := mp[parent]; !found {
			mp[parent] = []int{-1, -1}
		}

		if isLeft == 1 {
			mp[parent][0] = child
		} else {
			mp[parent][1] = child
		}
		childList = append(childList, child)
	}

	headNode := -1

	for k, _ := range mp {

		if !contains(childList, k) {
			headNode = k
			break
		}
	}

	return buildTree(mp, headNode)

}

func buildTree(mp map[int][]int, currentNode int) *TreeNode {

	newNode := TreeNode{Val: currentNode}

	if children, found := mp[currentNode]; found {

		if children[0] != -1 {
			newNode.Left = buildTree(mp, children[0])
		}

		if children[1] != -1 {
			newNode.Right = buildTree(mp, children[1])
		}
	}
	return &newNode

}

func contains(array []int, el int) bool {

	for _, ar := range array {
		if ar == el {
			return true
		}
	}
	return false
}
