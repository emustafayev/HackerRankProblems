package leet_code.till_april;

public class FlattenBinaryTreeToLInkedList {



      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
             this.right = right;
          }
      }



    public static void main(String[] args) {

    }

    //   1,2,5,3,4,null,6
    //   1,null,2,null,3,null,4,null,5,null,6]
    private static TreeNode prev = null;

    public static void flatten(TreeNode root) {
        flatten(root,null);
    }
    private static TreeNode flatten(TreeNode root, TreeNode pre) {
        if(root==null) return pre;
        pre=flatten(root.right,pre);
        pre=flatten(root.left,pre);
        root.right=pre;
        root.left=null;
        pre=root;
        return pre;
    }

//    void flatten(TreeNode* root) {
//        flat(root, nullptr);
//    }
//
//    TreeNode* flat(TreeNode* node, TreeNode* after) {
//        if (node == nullptr) {
//            return after;
//        }
//        TreeNode* right = flat(node->right, after);
//        node->right = flat(node->left, right);
//        node->left = nullptr;
//        return node;
//    }



}
