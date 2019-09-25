package easy;

import common.TreeNode;

public class Solution897 {
    TreeNode prev;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        prev = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        prev.right = node;
        prev = node;
        inorder(node.right);
    }
}
