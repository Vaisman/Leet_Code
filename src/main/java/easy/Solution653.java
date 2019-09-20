package easy;

import java.util.HashSet;
import java.util.Set;

import common.TreeNode;

public class Solution653 {
    Set<Integer> pocket = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        if (pocket.contains(k-root.val)) {
            return true;
        }
        else {
            pocket.add(root.val);
            return findTarget(root.right, k) || findTarget(root.left, k);
        }
    }
}
