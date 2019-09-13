package easy;

public class Solution453 {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int min = nums[0];
        int sum = 0;
        for(int i : nums) {
            min = Math.min(i, min);
            sum += i;
        }
        return sum - nums.length * min;
    }
}
