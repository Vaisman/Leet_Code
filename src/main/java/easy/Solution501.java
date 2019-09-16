package easy;

import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class Solution501 {
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[]{};

        int [] res = new int[]{};

        List<Integer> listResult = new ArrayList<>();
        traverse(root, listResult);

        return res;
    }

    Integer prev = null;
    int count = 1;
    int max = 0;

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (prev != null) {
            if (root.val == prev)
                count++;
            else
                count = 1;
        }

        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }

        prev = root.val;
        traverse(root.right, list);
    }
}
