package medium;

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int[] res = {0, 0};
        if (nums == null || nums.length == 0) return res;

        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        xor = xor & -xor;

        for (int i : nums) {
            if ((i & xor) == 0) // the bit is not set
            {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}
