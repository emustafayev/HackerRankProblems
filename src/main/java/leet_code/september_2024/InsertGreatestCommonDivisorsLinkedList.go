package main

import "fmt"

func main() {
	fmt.Println(findGCD(12, 18))
}

type ListNode2 struct {
	Val  int
	Next *ListNode2
}

func insertGreatestCommonDivisors(head *ListNode2) *ListNode2 {

	current := head

	for current != nil && current.Next != nil {

		gcd := findGCD(current.Val, current.Next.Val)

		temp := current.Next

		current.Next = &ListNode2{Val: gcd, Next: temp}

		current = current.Next.Next
	}

	return head
}

func findGCD(a, b int) int {

	if b == 0 {
		return a
	}
	return findGCD(b, a%b)

}

// gcd calculates the greatest common divisor (GCD) of two integers using the Euclidean algorithm.
func gcd(a, b int) int {
	if b == 0 {
		return a
	}
	return gcd(b, a%b)
}

func insertGreatestCommonDivisors2(head *ListNode) *ListNode {
	// Start from the head of the linked list
	current := head

	// Traverse the linked list
	for current != nil && current.Next != nil {
		// Calculate GCD of the current node and the next node
		gcdValue := gcd(current.Val, current.Next.Val)

		// Create a new node with the GCD value
		newNode := &ListNode{Val: gcdValue}

		// Insert the new node between current and next node
		newNode.Next = current.Next
		current.Next = newNode

		// Move to the next pair of nodes
		current = newNode.Next
	}

	return head
}
