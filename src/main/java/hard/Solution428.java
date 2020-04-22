package hard;

import java.util.*;

public class Solution428 {
    class TreeNode {
        public int val;
        public List<TreeNode> children;

        public TreeNode() {
        }

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, List<TreeNode> _children) {
            val = _val;
            children = _children;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new LinkedList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }

    private void serializeHelper(TreeNode root, List<String> list) {
        if (root == null) {
            return;
        } else {
            list.add(String.valueOf(root.val));
            list.add(String.valueOf(root.children.size()));
            for (TreeNode child : root.children) {
                serializeHelper(child, list);
            }
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;

        String[] ss = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(ss));
        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Queue<String> q) {
        TreeNode root = new TreeNode();
        root.val = Integer.parseInt(q.poll());
        int size = Integer.parseInt(q.poll());
        root.children = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            root.children.add(deserializeHelper(q));
        }
        return root;
    }
}