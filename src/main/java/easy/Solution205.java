package easy;

public class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return s == t;
        }

        if (s.length() != t.length()) {
            return false;
        }

        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int sIndex = s.charAt(i);
            int tIndex = t.charAt(i);
            if (m1[sIndex] != m2[tIndex]) return false;
            m1[sIndex] = i + 1;
            m2[tIndex] = i + 1;
        }
        return true;
    }
}
