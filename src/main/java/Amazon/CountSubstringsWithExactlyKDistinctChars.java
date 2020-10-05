package Amazon;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CountSubstringsWithExactlyKDistinctChars {
    public int subarraysWithKDistinct(char[] A, int K) {
        if (A == null || A.length < K) {
            return 0;
        }
        return atMost(A, K) - atMost(A, K-1);
    }

    public static int atMost(char[] A, int k) {
        int start = 0;
        int ret = 0;
        Map<Integer, Integer> count = new LinkedHashMap<>();

        for (int end = 0; end < A.length; end++) {
            if (count.containsKey(A[end])) {
                count.remove(A[end]);
            }

            count.put((int)A[end],  end);

            if (count.size() > k) {
                Map.Entry<Integer, Integer> leftmost = count.entrySet().iterator().next();
                count.remove(leftmost.getKey());
                start = leftmost.getValue()+1;
            }
            ret += end-start+1;
        }
        return ret;
    }
    @Test
    public void test() {
       assertEquals(7, subarraysWithKDistinct("pqpqs".toCharArray(), 2));
    }
}
