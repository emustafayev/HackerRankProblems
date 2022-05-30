package leet_code;

public class MergeTwoSortedList {


    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


//    You are given the heads of two sorted linked lists list1 and list2.
//
//    Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
//
//    Return the head of the merged linked list.


    public static void main(String[] args) {
        ListNode listNode = mergeTwoLists(null, null);
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else list2.next = mergeTwoLists(list1, list2.next);
        return list2;

    }


    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);

        ListNode curr = head;


        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }

        //remaining

        if (list1 != null) curr.next = list1;
        if (list2 != null) curr.next = list2;

        return head.next;
    }

}