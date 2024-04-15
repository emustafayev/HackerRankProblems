package main

import "fmt"

func main() {

}

type ListNode struct {
	Val  int
	Next *ListNode
}

func oddEvenList(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	if head.Next == nil {
		return head
	}
	current := head

	// [2,1,3,5,6,4,7]

	odd := current
	even := current.Next
	current = even.Next
	evenHead := even

	for current != nil {
		odd.Next = current // take odd one
		odd = current

		even.Next = current.Next // take even one
		even = current.Next

		fmt.Println(even)
		fmt.Println(odd)

		if even == nil {
			break
		}
		current = current.Next.Next
	}

	odd.Next = evenHead

	return head
}
