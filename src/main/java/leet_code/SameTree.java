package leet_code;

public class SameTree {

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

    public static void main(String[] args) {

    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true; // Returns end of the traverse
        if (p == null || q == null) return false;

        if (p.val == q.val)
            return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
        return false;
    }

}
