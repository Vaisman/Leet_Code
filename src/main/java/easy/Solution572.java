package easy;

import common.TreeNode;

public class Solution572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }
        return isEquals(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    boolean isEquals(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return s == t;
        }
        return s.val == t.val && isSubtree(s.left, t.left) && isEquals(s.right, t.right);
    }
}
