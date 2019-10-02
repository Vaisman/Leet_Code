package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution1002 {
    public List<String> commonChars(String[] A) {
        if (A == null || A.length == 0) {
            return Collections.emptyList();
        }

        List<String> res = new ArrayList<>();

        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);

        for (String str : A) {
            int[] cnt = new int[26];
            str.chars().forEach(c -> ++cnt[c - 'a']);
            for (int i = 0; i < 26; ++i) {
                count[i] = Math.min(cnt[i], count[i]);
            }
        }

        for (char c = 'a'; c <= 'z'; ++c) {
            while (count[c - 'a']-- > 0) {
                res.add("" + c);
            }
        }
        return res;
    }
}
