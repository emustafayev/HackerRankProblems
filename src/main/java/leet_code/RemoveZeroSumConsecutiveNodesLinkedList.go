package main

func main() {

}

func removeZeroSumSublists(head *ListNode) *ListNode {
	front := &ListNode{0, head}
	start := front
	for start != nil {
		end := start.Next
		prefixSum := 0
		for end != nil {
			prefixSum += end.Val
			if prefixSum == 0 {
				start.Next = end.Next
				break
			}
			end = end.Next
		}
		if end == nil {
			start = start.Next
		}
	}

	return front.Next
}

func removeZeroSumSublists2(head *ListNode) *ListNode {
	front := &ListNode{0, head}

	current := front
	m := make(map[int]*ListNode)

	prefixSum := 0
	for current != nil {
		prefixSum += current.Val
		m[prefixSum] = current
		current = current.Next
	}

	prefixSum = 0
	current = front

	for current != nil {
		prefixSum += current.Val
		current.Next = m[prefixSum].Next
		current = current.Next
	}
	return front.Next
}
