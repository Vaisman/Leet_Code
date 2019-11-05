package medium;

import common.TreeNode;

public class Solution513 {
    int maxHeight = -1;
    int targetValue = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return targetValue;
    }

    private void dfs(TreeNode root, int curHeight) {
        if (root.left == null && root.right == null) {
            if (curHeight > maxHeight) {
                maxHeight = curHeight;
                targetValue = root.val;
            }
        }
        if (root.left != null) dfs(root.left, curHeight+1);
        if (root.right != null) dfs(root.right, curHeight+1);
    }
}
