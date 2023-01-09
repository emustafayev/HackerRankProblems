package leet_code;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

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

    public static List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();

        traversal(root, res);

        return res;
    }

    private static void traversal(TreeNode root, ArrayList<Integer> res) {

        if (root == null) return;

        res.add(root.val);

        traversal(root.left, res);
        traversal(root.right, res);
    }

}
