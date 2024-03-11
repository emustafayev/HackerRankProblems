package leet_code;

public class DiameterofBinaryTree {
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

    public int diameterOfBinaryTree(TreeNode root) {

        findDia(root);
        return maxDiameter;
    }

    private int maxDiameter;

    public int findDia(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftL = findDia(root.left);
        int rightL = findDia(root.right);

        maxDiameter = Math.max(maxDiameter, leftL + rightL);

        return Math.max(leftL, rightL) + 1;
    }
}
