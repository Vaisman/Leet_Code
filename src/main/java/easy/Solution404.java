package easy;

import java.util.Stack;

import common.TreeNode;

public class Solution404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return traverse(root.left, true) + traverse(root.right, false);
    }

    private int traverse(TreeNode root, boolean isLeft) {
        if (root == null) {
            return 0;
        }

        if (root.right == null && root.left == null) {
            return  isLeft == true ? root.val : 0;
        }
        return traverse(root.left, true) + traverse(root.right, false);
    }

    public int sumOfLeftLeaves1(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();

        stack.push(root);

        while(!stack.empty()) {
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    ans += node.left.val;
                }
                stack.push(node.left);
            }
        }
        return ans;
    }
}
