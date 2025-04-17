package main

type listNode4 struct {
	Val  int
	Next *listNode4
}

func main() {

}

func mergeTwoLists(list1 *listNode4, list2 *listNode4) *listNode4 {
	var merged *listNode4

	if list1 == nil {
		return list2
	}

	if list2 == nil {
		return list1
	}

	if list1.Val <= list2.Val {
		merged = list1
		list1 = list1.Next
	} else {
		merged = list2
		list2 = list2.Next
	}

	head := merged

	for list1 != nil && list2 != nil {
		if list1.Val <= list2.Val {
			merged.Next = list1
			list1 = list1.Next
		} else {
			merged.Next = list2
			list2 = list2.Next
		}
		merged = merged.Next
	}
	if list1 != nil {
		merged.Next = list1
	}

	if list2 != nil {
		merged.Next = list2
	}

	return head
}
