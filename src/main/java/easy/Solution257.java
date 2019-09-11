package easy;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class Solution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return null;
        List<String> res = new ArrayList<>();

        traverse(res, "", root);
        return res;
    }

    private void traverse(List<String> res, String curr, TreeNode node) {
        if (node.left == null && node.right == null) {
            res.add(curr);
            return;
        }

        curr += node.val + "->";

        if (node.left != null)
            traverse(res, curr, node.left);
        if (node.right != null)
            traverse(res, curr, node.right);
    }
}
