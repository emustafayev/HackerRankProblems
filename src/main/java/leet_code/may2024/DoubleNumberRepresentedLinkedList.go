package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {

	l := &ListNode{
		Next: &ListNode{Next: &ListNode{Val: 9}, Val: 8},
		Val:  1,
	}

	doubleIt(l)

}

func doubleIt(head *ListNode) *ListNode {
	ans := head
	if head.Val >= 5 {
		head = &ListNode{Val: 1, Next: head}
		ans = head
		head = head.Next
	}

	for head != nil && head.Next != nil {

		if head.Next.Val < 5 {
			head.Val = (head.Val * 2) % 10
		} else {
			head.Val = (head.Val*2 + 1) % 10
		}

		head = head.Next
	}

	head.Val = (head.Val * 2) % 10
	return ans
}
