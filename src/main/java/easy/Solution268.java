package easy;

public class Solution268 {
    public int missingNumber(int[] nums) {
        if (nums == null) return -1;
        int xor = 0;
        for (int i = 0; i< nums.length ; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return  xor ^ nums.length ;
    }
}

/*
Input: [3,0,1]
Output: 2
*/