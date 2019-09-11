package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution290 {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || pattern.length() == 0 || str == null || str.length() == 0) {
            return false;
        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        String[] splitted = str.split(" ");
        if (splitted.length != pattern.length()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(map1.put(String.valueOf(pattern.charAt(i)), i), map2.put(splitted[i], i)))
                return false;
        }
        return true;
    }
}

/*
Input: pattern = "abba", str = "dog cat cat dog"
Output: true
*/