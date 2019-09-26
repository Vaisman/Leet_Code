package easy;

import java.util.Arrays;

public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];

        for (char c : chars.toCharArray())
            seen[c - 'a']++;

        for (String word : words) {
            int[] tSeen = Arrays.copyOf(seen, seen.length);
            int currentCount = 0;
            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    currentCount++;
                }
            }
            if (currentCount == word.length())
                count += currentCount;
        }
        return count;
    }
}
