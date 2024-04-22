package main

import (
	"fmt"
)

type TreeNodeSL struct {
	Val   int
	Left  *TreeNodeSL
	Right *TreeNodeSL
}

func main() {

	root := &TreeNodeSL{
		0,
		&TreeNodeSL{
			1,
			&TreeNodeSL{3, nil, nil},
			&TreeNodeSL{4, nil, nil},
		},
		&TreeNodeSL{
			2,
			&TreeNodeSL{3, nil, nil},
			nil,
		},
	}
	fmt.Println(smallestFromLeaf(root))

}

func smallestFromLeaf(root *TreeNodeSL) string {

	ans := ""

	var dfs func(node *TreeNodeSL, text string)

	dfs = func(node *TreeNodeSL, text string) {

		if node == nil {
			return
		}
		text = string(rune(node.Val+97)) + text
		if node.Right == nil && node.Left == nil {
			if ans == "" || ans > text {
				ans = text
			}

			return
		}

		dfs(node.Left, text)
		dfs(node.Right, text)
	}

	dfs(root, "")

	return ans
}
