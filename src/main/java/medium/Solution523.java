package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }
}
    /*
        Input: [23, 2, 4, 6, 7],  k=6
        Output: True
        Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
        sum 23 map 4 - 0
        25     1 - 1
        29     5 - 2
        35     1
    */