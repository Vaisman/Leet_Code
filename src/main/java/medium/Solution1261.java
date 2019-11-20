package medium;

import java.util.HashSet;
import java.util.Set;

import common.TreeNode;

public class Solution1261 {
    private Set<Integer> seen = new HashSet<>();

    public Solution1261(TreeNode root) {
        dfs(root, 0);
    }

    private void dfs(TreeNode n, int v) {
        if (n == null) return;
        seen.add(v);
        n.val = v;
        dfs(n.left, 2 * v + 1);
        dfs(n.right, 2 * v + 2);
    }

    public boolean find(int target) {
        return seen.contains(target);
    }
}
