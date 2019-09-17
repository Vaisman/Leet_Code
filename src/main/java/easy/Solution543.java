package easy;

import common.TreeNode;

public class Solution543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max;
    }

    private int traverse(TreeNode node) {
        if  (node == null) return 0;
        int left = traverse(node.left);
        int right = traverse(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
