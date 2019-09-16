package easy;

public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxChain = 0;
        int currentChain = 0;

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                maxChain = Math.max(maxChain, currentChain);
                currentChain = 0;
            }
            else {
                currentChain++;
            }
        }
        maxChain = Math.max(maxChain, currentChain);
        return maxChain;
    }
}
