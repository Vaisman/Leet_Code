package medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution152 {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int pos = 1;
        int neg = 1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i< nums.length; i++ ) {
            if (nums[i] < 0){
                int temp = pos;
                pos = neg;
                neg = temp;
            }

            pos = Math.max(nums[i], nums[i]*pos);
            neg = Math.min(nums[i], nums[i]*neg);
            max = Math.max(max, pos);
        }

        return max;
    }

    public int maxProduct1(int[] nums) {
        int prod = 1;
        int result = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) {
                prod = 1;
            }
        }
        prod = 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) {
                prod = 1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        maxProduct1(new int[]{1,-2, 3, 2});
    }
}
