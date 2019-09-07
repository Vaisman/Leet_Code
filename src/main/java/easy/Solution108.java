package easy;

import common.TreeNode;

public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length-1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        int mid = (l+r) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, l, mid -1);
        node.right = helper(nums, mid+1, r);
        return node;
    }
}
