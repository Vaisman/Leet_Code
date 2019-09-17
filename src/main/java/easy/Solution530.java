package easy;

import common.TreeNode;

public class Solution530 {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        traverse(root);
        return diff;
    }

    int diff = Integer.MAX_VALUE;
    TreeNode prev = null;
    private void traverse(TreeNode root) {
        if (root == null) return;

        traverse(root.left);
        if (prev != null)
            diff = Math.min(diff, Math.abs(prev.val - root.val));

        prev = root;
        traverse(root.right);
    }
}
