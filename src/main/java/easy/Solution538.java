package easy;

import java.util.Stack;

import common.TreeNode;

public class Solution538 {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;

        convertBST(root.right);

        root.val += sum;
        sum = root.val;

        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST1(TreeNode root) {
        if (root == null) return null;
        int sum = 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            int tmp = cur.val;
            cur.val += sum;
            sum += tmp;
            cur = cur.left;
        }
        return root;
    }
}
