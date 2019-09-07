package easy;

import common.TreeNode;

public class Solution112 {
    private boolean searchBST(TreeNode root, int sum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null) {
            if ((sum - root.val) == 0)
                return true;
            else
                return false;
        }

        return searchBST(root.left, sum -root.val) || searchBST(root.right, sum -root.val);
    }
}
