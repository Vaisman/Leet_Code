package medium;

import common.TreeNode;

import java.util.*;

public class Solution314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Integer> levels = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        levels.offer(0);

        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                int level = levels.poll();
                min = Math.min(level, min);
                max = Math.max(level, max);
                map.putIfAbsent(level, new ArrayList<>());
                map.get(level).add(curr.val);
                if (curr.left != null) {
                    levels.offer(level - 1);
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    levels.offer(level + 1);
                    q.offer(curr.right);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
