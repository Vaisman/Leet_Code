package easy;

public class Solution53 {
    public int maxSubArray(int[] nums) {
        if (nums ==null || nums.length == 0)
            return 0;

        int maxSum = nums[0];
        int sum = nums[0];
        for(int i = 1; i< nums.length; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
/*
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
*/