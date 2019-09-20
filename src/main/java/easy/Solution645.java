package easy;

public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        int[] ans = new int[2];
        if (nums == null || nums.length == 0) return ans;

        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            ans[1] ^= (i+1) ^ val;
            if (nums[val-1] < 0) {
                ans[0] = val;
            }
            else {
                nums[val-1] = -nums[val-1];
            }
        }

        ans[1] ^= ans[0];
        return ans;
    }
}
