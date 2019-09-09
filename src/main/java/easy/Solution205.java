package easy;

import java.util.HashMap;
import java.util.Map;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (map.containsKey(sChar)) {
                if (!map.get(sChar).equals(tChar)) {
                    return false;
                }
            }
            else {
                if (map.containsKey(tChar)) {
                    return false;
                }
                else {
                    map.put(sChar, tChar);
                }
            }
        }
        return true;
    }
}
