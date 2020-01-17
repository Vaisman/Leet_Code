package medium;

import org.junit.Test;

import java.util.Arrays;

public class Solution962 {
    public int maxWidthRamp(int[] A) {
        int N = A.length;
        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i;

        Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));

        int ans = 0;
        int m = N;
        for (int i: B) {
            ans = Math.max(ans, i - m);
            m = Math.min(m, i);
        }

        return ans;
    }

    @Test
    public void test(){
        maxWidthRamp(new int[]{6,0,8,2,1,5});
    }
}
