package Amazon;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestStringMadeUpOfOnlyVowels {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int longestString(String s) {
        int len = s.length();
        int start = 0;
        int end = len - 1;
        while (start < len && isVowel(s.charAt(start))) {
            ++start;
        }

        while (end >= 0 && isVowel(s.charAt(end))) {
            --end;
        }

        // checking area come to [start, end]
        if (start >= len) {
            return len;
        }

        int res = start + len - 1 - end;

        int longest = 0;
        int sum = 0;
        for (int i = start + 1; i <= end; ++i) {
            if (isVowel(s.charAt(i)))
                ++sum;
            else
                sum = 0;
            longest = Math.max(sum, longest);
        }
        return longest + res;
    }

    @Test
    public void test() {
        assertEquals(3, longestString("earthproblem"));
    }
}
