package medium;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Solution1637 {
    public int minDeletions(String s) {
        int cnt[] = new int[26], res = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < s.length(); ++i)
            ++cnt[s.charAt(i) - 'a'];
        for (int i = 0; i < 26; ++i) {
            int freq = cnt[i];
            while (freq > 0 && !used.add(freq)) {
                --freq;
                ++res;
            }
        }
        return res;
    }

    @Test
    public void test() {
        minDeletions("aab");
    }
}
