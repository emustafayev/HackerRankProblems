package leet_code;

public class MiddleLinkedList {


     // Definition for singly-linked list.
     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static void main(String[] args) {

    }

    public static ListNode middleNode1(ListNode head) {

        ListNode[] arr = new ListNode[100];
        int counter = 0;
        while (head != null) {
            arr[counter++] = head;
            head = head.next;
        }
        return arr[counter / 2];
    }

    public static ListNode middleNode2(ListNode head) {

         ListNode slow = head, fast = head;

        while (fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }



}
