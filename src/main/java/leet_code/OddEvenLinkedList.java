package leet_code;

public class OddEvenLinkedList {


    public static void main(String[] args) {
        //[1,2,3,4,5]

        var head = new ListNode(1);

        var current = new ListNode(2);
        head.next = current;

        current.next = new ListNode(3);


    }


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

        @Override
        public String toString() {
            return " " + val + " ";
        }
    }

    public ListNode oddEvenList(ListNode head) {
        throw new IllegalArgumentException("Not impl yet");
    }

}
