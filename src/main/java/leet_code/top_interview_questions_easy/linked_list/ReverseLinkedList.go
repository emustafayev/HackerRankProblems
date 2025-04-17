package main

func main() {

	reverseList(&listNode3{
		Val: 4,
		Next: &listNode3{
			Val: 6,
			Next: &listNode3{
				Val: 8,
			},
		},
	})
}

type listNode3 struct {
	Val  int
	Next *listNode3
}

func reverseList(head *listNode3) *listNode3 {
	var prev *listNode3
	curr := head
	for curr != nil {
		next := curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}
	return prev
}
