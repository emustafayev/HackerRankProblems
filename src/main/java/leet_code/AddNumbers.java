package leet_code;

import java.util.Arrays;
import java.util.LinkedList;

public class AddNumbers {

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


    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9,new ListNode(9))));

        ListNode res = addTwoNumbers(l1, l2);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode res = new ListNode();
        fakeHead.next = res;

        int reminder = 0;
        int sum;
        while (l1 != null || l2 != null) {
            int x = l1 != null? l1.val : 0;
            int y = l2 != null? l2.val : 0;
            sum = x + y+reminder;
            reminder = sum / 10;
            res.next = new ListNode(sum%10);
            res = res.next;

            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }

        if (reminder > 0){
            res.next = new ListNode(reminder);
        }

        return fakeHead.next.next;
    }
}
