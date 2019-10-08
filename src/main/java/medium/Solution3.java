package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c))
                j = Math.max(j, map.get(c));
            map.put(c, i+1);
            max = Math.max(max, i-j+1);
        }
        return max;
    }
}
