package easy;

public class Solution680 {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int l = 0;
        int r = s.length()-1;
        while(l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else return isPalindrome(s, l+1, r) || isPalindrome(s, l,r-1);
        }
        return true;
    }

    boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l++;
                r--;
            }
            else return false;
        }
        return true;
    }
}
