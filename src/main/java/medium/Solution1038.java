package medium;

import common.TreeNode;

public class Solution1038 {
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) {
            bstToGst(root.right);
        }
        pre = root.val = pre + root.val;
        if (root.left != null) {
            bstToGst(root.left);
        }
        return root;
    }
}
