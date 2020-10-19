package FooBar;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution1 {

    private static final int MAX_LENGTH = 200;
    public static int solution(String x) {
        int length = x.length();
        int maxNumEqualParts = 1;

        if (length <= MAX_LENGTH) {
            for (int i = 1; i <= length; i++) {
                int equalPartsCount = 0;
                String subStr = null;

                if (length % i == 0) {
                    subStr = x.substring(0, length / i);
                    equalPartsCount = countNumOfSubstrings(x, subStr);
                    if (equalPartsCount == length / subStr.length() && equalPartsCount > maxNumEqualParts) {
                        maxNumEqualParts = equalPartsCount;
                    }
                }
            }
        }
        return maxNumEqualParts;
    }

    private static int countNumOfSubstrings(String str, String strToFind) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = str.indexOf(strToFind, lastIndex);
            if (lastIndex != -1) {
                lastIndex += strToFind.length();
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertEquals(4, solution("abcabcabcabc"));
        assertEquals(2, solution("abccbaabccba"));
    }
}