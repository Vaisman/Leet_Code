package easy;

import java.util.Arrays;

public class Solution594 {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int min =0;
        int count = 0;
        for(int i=1; i<nums.length;)
        {
            if(nums[i]-nums[min]==0) {
                i++;
            }
            else if (nums[i]-nums[min] == 1) {
                count = Math.max(count, i - min + 1);
                i++;
            }
            else {
                min++;
            }
        }
        return count;
    }
}
