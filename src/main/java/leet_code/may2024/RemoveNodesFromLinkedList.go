package main

func main() {

}

func removeNodes2(head *ListNode) *ListNode {
	if head.Next == nil {
		return head
	}

	head.Next = removeNodes2(head.Next)
	if head.Val < head.Next.Val {
		return head.Next
	}

	return head
}

func removeNodes(head *ListNode) *ListNode {

	if head == nil {
		return nil
	}

	// Space: O(n)
	var stack []*ListNode
	var current = head

	// Time: O(n)
	for current != nil {
		for len(stack) > 0 && current.Val > stack[len(stack)-1].Val {
			stack = stack[:len(stack)-1]
		}

		stack = append(stack, current)
		current = current.Next
	}

	var newHead *ListNode

	// Time: O(n/x) = O(n)
	for i := len(stack) - 1; i >= 0; i-- {
		stack[i].Next = newHead
		newHead = stack[i]
	}

	return newHead
}
