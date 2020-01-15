package medium;

import org.junit.Test;

public class Solution424 {
    public int characterReplacement(String s, int k) {
        int uniqueCount = 0;
        int left = 0;
        int max = 0;
        int[] count = new int[26];

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            uniqueCount = Math.max(uniqueCount, ++count[c - 'A']);
            int replaceCount = right - left + 1 - uniqueCount;

            if (replaceCount > k) {
                // invalid window
                count[s.charAt(left) - 'A']--;
                left++;
            } else {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }

    @Test
    public void test(){
        characterReplacement("ABAB", 2);
    }
}
