package easy;

public class Solution345 {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        String vowels = "aeiouAEIOU";

        char[] chars = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {

            // find left vowel
            while (start < end && !vowels.contains("" + chars[start])) {
                start++;
            }

            // find right vowel
            while (start < end && !vowels.contains("" + chars[end])) {
                end--;
            }

            // swap
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;

            start++;
            end--;
        }
        return new String(chars);
    }
}
