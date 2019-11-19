package easy;

import org.junit.Test;

public class Solution1221 {
    public int balancedStringSplit(String s) {
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == 'L' ? 1 : -1;
            if (cnt == 0) ++res;
        }
        return res;
    }

    @Test
    public void test() {
        balancedStringSplit("RLRRLLRLRL");
    }
}
