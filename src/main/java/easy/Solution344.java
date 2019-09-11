package easy;

public class Solution344 {
    public void reverseString(char[] s) {
        if (s == null) return;

        int i = 0;
        int j = s.length-1;
        while (i < j) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
            i++;
            j--;
        }
    }
}
