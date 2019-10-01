package easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        if (A == null || A.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> res = new LinkedList<>();
        for (int i = A.length - 1; i >= 0; --i) {
            res.add(0, (A[i] + K) % 10);
            K = (A[i] + K) / 10;
        }

        while (K > 0) {
            res.add(0, K % 10);
            K /= 10;
        }
        return res;
    }
}
