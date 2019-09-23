package easy;

public class Solution724 {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }

        int left = 0;
        for(int i = 0; i< nums.length; i++) {
            sum -= nums[i];
            if (sum == left)
                return i;
            left += nums[i];
        }
        return -1;
    }
}
