package easy;

public class Solution169 {
    public int majorityElement(int[] nums) {
        int result = 0;
        int count = 0;

        for (int n : nums ) {
            if (count == 0)
                result = n;

            if (result == n) {
                count++;
            }
            else {
                count--;
            }
        }
        return result;
    }
}
