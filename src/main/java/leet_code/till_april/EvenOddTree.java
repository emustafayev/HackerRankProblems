package leet_code.till_april;

import java.util.PriorityQueue;

public class EvenOddTree {
    public static void main(String[] args) {

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isEvenOddTree(TreeNode root) {

            TreeNode head = root;

            PriorityQueue<TreeNode> queue = new PriorityQueue<>();


            return false;

        }
    }

}
