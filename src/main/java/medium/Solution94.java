package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> q = new Stack<>();
        if (root == null) return res;

        while (root != null || !q.isEmpty()) {
            while (root != null) {
                q.push(root);
                root = root.left;
            }
            root = q.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
