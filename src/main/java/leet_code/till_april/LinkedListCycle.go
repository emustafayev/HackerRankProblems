package main

type ListNodeX struct {
	Val  int
	Next *ListNodeX
}

func hasCycle(head *ListNodeX) bool {

	if head == nil {
		return false
	}
	slow := head
	fast := head

	for fast != nil && fast.Next != nil {
		fast = fast.Next.Next
		slow = slow.Next
		if slow == fast {
			return true
		}

	}
	return false
}
