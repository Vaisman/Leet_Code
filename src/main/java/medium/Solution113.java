package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

public class Solution113 {
    private List<List<Integer>> resultList = new ArrayList<>();

    public void pathSumInner(TreeNode root, int sum, Stack<Integer> path) {
        if (root == null)
            return;

        path.push(root.val);

        if (root.left == null && root.right == null)
            if(sum == root.val)
                resultList.add(new ArrayList<>(path));

        pathSumInner(root.left, sum-root.val, path);
        pathSumInner(root.right, sum-root.val, path);

        path.pop();
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return resultList;

        Stack<Integer> path = new Stack<>();
        pathSumInner(root, sum, path);

        return resultList;
    }
}
