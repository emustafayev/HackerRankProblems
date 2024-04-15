package leet_code.till_april;

public class RangeSumOfBST {
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


    public int rangeSumBST(TreeNode root, int low, int high) {

        int[] sum = new int[]{0};

         _rangeSumBST(root, low, high, sum);
         return sum[0];
    }

    private void _rangeSumBST(TreeNode root, int low, int high, int[] sum) {
        if (root == null) return;
        if (root.val >= low && root.val < high) {
            System.out.println(root.val);
            sum[0] += root.val;
        }
        _rangeSumBST(root.left, low, high, sum);
        _rangeSumBST(root.right, low, high, sum);
    }
}
