package medium;

import common.TreeNode;

public class Solution129 {
    private int search(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum*10 + root.val;
        if (root.left == null && root.right == null) return sum;
        return search(root.left, sum) + search(root.right, sum);
    }

    public int sumNumbers(TreeNode root) {
        int sum = 0;
        return search(root, sum);
    }
}
