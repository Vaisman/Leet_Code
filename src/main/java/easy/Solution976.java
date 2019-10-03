package easy;

import java.util.Arrays;

public class Solution976 {
    public int largestPerimeter(int[] A) {
        if (A == null || A.length <3) {
           return -1;
        }

        Arrays.sort(A);

        for (int i = A.length - 1; i > 1; --i)
            if (A[i] < A[i - 1] + A[i - 2])
                return A[i] + A[i - 1] + A[i - 2];
        return 0;
    }
}
