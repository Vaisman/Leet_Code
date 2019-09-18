package easy;

import common.TreeNode;

public class Solution563 {
    int result = 0;

    private int postorder(TreeNode root) {
        if (root == null)
            return 0;

        int left = postorder(root.left);
        int right = postorder(root.right);
        result += Math.abs(left - right);

        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {
        postorder(root);
        return result;
    }
}
