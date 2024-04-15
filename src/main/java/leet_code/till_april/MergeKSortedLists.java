package leet_code.till_april;

public class MergeKSortedLists {
//    https://leetcode.com/problems/merge-k-sorted-lists/description/
    public static void main(String[] args) {


    }

//    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//    Merge all the linked-lists into one sorted linked-list and return it.
//
//
//
//            Example 1:
//
//    Input: lists = [[1,4,5],[1,3,4],[2,6]]
//    Output: [1,1,2,3,4,4,5,6]
//    Explanation: The linked-lists are:
//            [
//            1->4->5,
//            1->3->4,
//            2->6
//            ]
//    merging them into one sorted list:
//            1->1->2->3->4->4->5->6


  public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode root = new ListNode(Integer.MIN_VALUE);

        ListNode mover = root;

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null && lists[i].val <= min){
                min = lists[i].val;
                mover.next = new ListNode(min);
                lists[i] = lists[i].next;
                mover = mover.next;
            }
        }

        return root.next;
    }

}
