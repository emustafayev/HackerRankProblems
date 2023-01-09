package leet_code;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {

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

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        traversal(root, res);

        return res;
    }

    private void traversal(TreeNode root, ArrayList<Integer> res) {

        if (root == null) return;

        traversal(root.left,res);

//        res.add(root.val); ===>>>> For in order version of order

        traversal(root.right,res);

        res.add(root.val);

    }
}
