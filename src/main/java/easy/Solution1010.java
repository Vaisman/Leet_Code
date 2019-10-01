package easy;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> count = new HashMap<>();

        int ans = 0;
        for (int t : time) {
            int d = (60 - t % 60) % 60;
            ans += count.getOrDefault(d, 0);
            count.put(t % 60, count.getOrDefault(t % 60, 0) + 1);
        }

        return ans;
    }

    @Test
    public void test() {
        assertEquals(numPairsDivisibleBy60(new int[]{30,20,150,100,40}), 3 );
    }
}
