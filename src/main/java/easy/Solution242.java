package easy;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return s == t;
        if (s.length() != t.length()) return false;

        int[] map = new int[26];
        for(char c: s.toCharArray()) {
            map[c]++;
        }
        for(char c: t.toCharArray()) {
            map[c]--;
        }
        for(int i: map) {
            if (i != 0) return false;
        }
        return true;
    }
}

/*
Input: s = "anagram", t = "nagaram"
Output: true
*/