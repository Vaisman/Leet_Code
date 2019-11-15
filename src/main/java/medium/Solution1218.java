package medium;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Solution1218 {
    public int longestSubsequence(int[] arr, int diff) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int a : arr) {
            if (map.containsKey(a - diff)) {
                map.put(a, map.get(a - diff) + 1);
            } else {
                map.put(a, 1);
            }
            max = Math.max(map.get(a), max);
        }
        return max;
    }

    @Test
    public void test() {
        longestSubsequence(new int [] {1,2,3,5,6}, 1);
    }
}
