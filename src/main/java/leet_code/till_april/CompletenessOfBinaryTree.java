package leet_code.till_april;


import java.util.LinkedList;
import java.util.Queue;

public class CompletenessOfBinaryTree {


    public static void main(String[] args) {


    }

    public static boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> qu = new LinkedList<TreeNode>();

        qu.offer(root);

        while (qu.peek() != null) {
            TreeNode curr = qu.poll();
            qu.offer(curr.left);
            qu.offer(curr.right);
            System.out.println(qu);
        }

        System.out.println(qu);

        while (!qu.isEmpty() && qu.peek() == null) {
            qu.remove();
        }

        return qu.isEmpty();

    }


    public class TreeNode {
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
}
