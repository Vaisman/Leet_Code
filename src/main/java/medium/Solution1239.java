package medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution1239 {
    private int res = 0;

    public int maxLength(List<String> arr) {
        int[] reps = new int[arr.size()];

        for (int i = 0; i < reps.length; i++) {
            String s = arr.get(i);
            for (int j = 0; j < s.length(); j++) {
                int mask = 1 << (s.charAt(j) - 'a');
                if ((reps[i] & mask) != 0) {
                    reps[i] = 0;
                    break;
                }
                reps[i] |= mask;
            }
        }

        dfs(reps, 0, 0);
        return res;
    }

    private void dfs(int[] reps, int pos, int mask) {
        if (pos == reps.length) {
            res = Math.max(res, Integer.bitCount(mask));
        }

        for (int i = pos; i < reps.length; i++) {
            if (reps[i] != 0 && (mask | reps[i]) == (mask ^ reps[i])) {
                dfs(reps, i+1, mask | reps[i]);
            }
        }

        res = Math.max(res, Integer.bitCount(mask));
    }

    @Test
    public void test() {
        maxLength(Arrays.asList("un","iq","ue"));
    }
}
