package easy;

import java.util.LinkedList;
import java.util.Queue;

import common.TreeNode;

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree1(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            TreeNode n1 = node.left;
            TreeNode n2 = node.right;
            node.right = n1;
            node.left = n2;
        }

        return root;
    }
}
