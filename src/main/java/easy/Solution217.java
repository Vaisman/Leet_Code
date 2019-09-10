package easy;

import java.util.HashSet;
import java.util.Set;

public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1)
            return false;

        Set<Integer> mem = new HashSet<>();
        for (int i: nums) {
            if (mem.contains(i))
                return true;
            mem.add(i);
        }
        return false;
    }
}
