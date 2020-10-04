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
        int sum = 0;
        while (start < len && isVowel(s.charAt(start))) {
            ++start;
            sum++; //count of vowels at start of string
        }

        while (end >= 0 && isVowel(s.charAt(end))) {
            --end;
            sum++; //count of vowels at end of string
        }

        // checking area come to [start, end]
        if (start >= len) {
            return len;
        }

        int longestLength = 0;
        int currLength = 0;
        // Find longest vowel sub string between start and end
        while(start <=end)
        {
            if(isVowel(s.charAt(start)))
                currLength++;
            else
            {
                longestLength = Math.max(currLength, longestLength);
                currLength = 0;
            }
            start++;
        }
        return longestLength + sum;
    }

    @Test
    public void test() {
        assertEquals(3, longestString("earthproblem"));
    }
}
