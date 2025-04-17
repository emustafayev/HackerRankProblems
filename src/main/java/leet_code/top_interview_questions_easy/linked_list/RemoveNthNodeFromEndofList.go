package main

func main() {

}

type listNode2 struct {
	Val  int
	Next *listNode2
}

func removeNthFromEnd(head *listNode2, n int) *listNode2 {

	slow, fast := head, head

	for i := 0; i < n; i++ {
		fast = fast.Next
	}

	for fast.Next != nil {
		fast = fast.Next
		slow = slow.Next
	}

	slow.Next = slow.Next.Next

	return head
}
