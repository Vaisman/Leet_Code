package medium;

import java.util.Stack;

import common.TreeNode;

public class Solution173 {
    private Stack<TreeNode> stack = new Stack<>();

    public Solution173(TreeNode root) {
        pushAll(root);
    }

    public boolean hasNext() {
        return !stack.empty();
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    private void pushAll(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
