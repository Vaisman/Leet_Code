package easy;

import common.TreeNode;

public class Solution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return root;
        if ((root.val <  p.val) && (root.val <  q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if ((root.val >  p.val) && (root.val >  q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (((root.val - p.val) * (root.val - q.val)) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}
