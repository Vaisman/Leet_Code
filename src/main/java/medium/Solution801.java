package medium;

import org.junit.Test;

public class Solution801 {
    public int minSwap(int[] A, int[] B) {
        // s: swap, n: not swap
        int n1 = 0;
        int s1 = 1;
        for(int i = 1; i < A.length; i++) {
            int n2 = Integer.MAX_VALUE;
            int s2 = Integer.MAX_VALUE;
            // case 1: a1 < a2 and b1 < b2, not swap or swap 2 pairs
            if(A[i - 1] < A[i] && B[i - 1] < B[i]) {
                n2 = Math.min(n2, n1);      // not swap
                s2 = Math.min(s2, s1 + 1);  // swap both
            }
            // case 2: a1 < b2 and b1 < a2, swap only 1 pair (a1b1 or a2b2)
            if(A[i - 1] < B[i] && B[i - 1] < A[i]) {
                n2 = Math.min(s1, n2);    // swap a1b1
                s2 = Math.min(n1 + 1, s2);  // swap a2b2
            }

            n1 = n2;
            s1 = s2;
        }
        return Math.min(n1, s1);
    }

    @Test
    public void test() {
        minSwap(new int[]{1,3,5,4}, new int[]{1,3,5,4});
    }
}
