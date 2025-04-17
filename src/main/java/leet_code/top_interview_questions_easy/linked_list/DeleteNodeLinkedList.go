package main

type listNode struct {
	Val  int
	Next *listNode
}

func main() {

}

func deleteNode(node *listNode) {
	if node == nil || node.Next == nil {
		return
	}
	node.Val = node.Next.Val
	node.Next = node.Next.Next
}
