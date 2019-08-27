package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <2)
            return null;

        int res[] = new int [2];
        Map<Integer, Integer> hash = new HashMap<>();

        for(int i = 0; i< nums.length; i++) {
            int delta = target - nums[i];
            if (hash.containsKey(delta)) {
                res[0] = i;
                res[1] = hash.get(delta);
                return res;
            }
            hash.put(nums[i], i);
        }
        return res;
    }
}
