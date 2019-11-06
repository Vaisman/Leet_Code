package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import common.TreeNode;

public class Solution652 {
    private Map<String, Integer> count;
    private List<TreeNode> ans;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans;
    }

    private String collect(TreeNode node) {
        if (node == null) return "#";

        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);

        if (count.get(serial) == 2) {
            ans.add(node);
        }

        return serial;
    }
}
