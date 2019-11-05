package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;

        Map<Integer, Integer> mem = new HashMap<>();

        for(int i = 0; i< A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                mem.put(A[i] + B[j], mem.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }

        for(int i = 0; i< C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                count += mem.getOrDefault(-( C[i] + D[j]), 0);
            }
        }

        return count;
    }
}
