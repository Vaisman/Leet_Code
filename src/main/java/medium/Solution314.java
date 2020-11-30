package medium;

import common.TreeNode;

import java.util.*;

public class Solution314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();

        helper(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, List<Integer>> column : map.values()) {
            List<Integer> list = new ArrayList<>();
            for (List<Integer> nodes : column.values()) {
                for (Integer node : nodes) {
                    list.add(node);
                }
            }
            result.add(list);
        }

        return result;
    }

    private void helper(TreeNode root, int col, int row, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(col)) {
            map.put(col, new TreeMap<>());
        }

        if (!map.get(col).containsKey(row)) {
            map.get(col).put(row, new ArrayList<Integer>());
        }

        map.get(col).get(row).add(root.val);
        helper(root.left, col - 1, row + 1, map);
        helper(root.right, col + 1, row + 1, map);
    }
}
