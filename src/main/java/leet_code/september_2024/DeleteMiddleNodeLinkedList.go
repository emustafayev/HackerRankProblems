package main

type ListNode3 struct {
	Val  int
	Next *ListNode3
}

func deleteMiddle(head *ListNode) *ListNode {

	if head.Next == nil {
		return nil
	}

	slow := head
	prevSlow := slow
	fast := head

	for fast != nil && fast.Next != nil {
		prevSlow = slow
		slow = slow.Next
		fast = fast.Next.Next
	}
	prevSlow.Next = slow.Next
	return head
}

func deleteMiddle2(head *ListNode) *ListNode {
	dummy := &ListNode{0, head}
	slow, fast := dummy, head
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}
	slow.Next = slow.Next.Next
	return dummy.Next
}
