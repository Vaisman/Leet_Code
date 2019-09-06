package easy;

public class Solution58 {
    public int lengthOfLastWord(String s) {
        int len = s.length() - 1;
        int lastLength = 0;

        // trim
        while (len >= 0 && s.charAt(len) == ' ') {
            len--;
        }

        // calculate
        while (len >= 0 && s.charAt(len) != ' ') {
            lastLength++;
            len--;
        }

        return lastLength;
    }
}
