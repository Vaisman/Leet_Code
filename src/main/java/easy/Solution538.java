package easy;

import java.util.Stack;

import common.TreeNode;

public class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        DFS(root, 0);
        return root;
    }

    public int DFS(TreeNode root, int preSum){
        if(root.right != null)
            preSum = DFS(root.right, preSum);
        root.val = root.val + preSum;
        return (root.left != null) ? DFS(root.left, root.val) : root.val;
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
