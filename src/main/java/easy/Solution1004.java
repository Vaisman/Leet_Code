package easy;

import org.junit.Test;

public class Solution1004 {
    public int longestOnes(int[] A, int K) {
        // validation

        int zeroCount = 0;
        int start = 0;
        int res = 0;
        for (int end = 0; end < A.length; end++) {
            if (A[end] == 0) {
                zeroCount++;
            }

            while (zeroCount > K) {
                if (A[start] == 0) zeroCount--;
                start++;
            }

            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    @Test
    public void test() {
        longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2);
    }
}
