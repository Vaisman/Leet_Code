package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution862 {
    public int shortestSubarray(int[] A, int K) {
        int N = A.length, res = N + 1;
        int[] B = new int[N + 1];
        // prefix sum
        for (int i = 0; i < N; i++) {
            B[i + 1] = B[i] + A[i];
        }

        Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (d.size() > 0 && B[i] - B[d.getFirst()] >=  K)
                res = Math.min(res, i - d.pollFirst());

            while (d.size() > 0 && B[i] <= B[d.getLast()])
                d.pollLast();

            d.addLast(i);
        }
        return res <= N ? res : -1;
    }
}
