package easy;

public class Solution392 {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0)
            return true;
        if (t == null || t.length() == 0)
            return true;

        int i =0;
        int j =0;
        while (i<s.length() && j <t.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
            j++;
        }
        return false;
    }
}
