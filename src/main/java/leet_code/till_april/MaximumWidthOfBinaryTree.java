package leet_code.till_april;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumWidthOfBinaryTree {

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

    static class Pair<T, S>{
        T node;
        S index;

        public Pair(T root, S i) {
            this.index = i;
            this.node = root;
        }
    }

    public static void main(String[] args) {
        
    }

    public static int widthOfBinaryTree(TreeNode root) {

        if (root == null) return 0;

        Deque<Pair<TreeNode, Integer>> q = new ArrayDeque<>(); // {node, index}
        q.offer(new Pair<>(root, 1));

        System.out.println(Arrays.toString(q.toArray()));

//
//        while (!q.isEmpty()){
//
//        }

        throw new IllegalArgumentException("Not impl yet");

    }
}
