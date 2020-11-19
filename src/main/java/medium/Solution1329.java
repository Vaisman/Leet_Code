package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1329 {
    public int[][] diagonalSort(int[][] A) {
        int m = A.length, n = A[0].length;
        Map<Integer, PriorityQueue<Integer>> d = new HashMap<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                d.putIfAbsent(i - j, new PriorityQueue<>());
                d.get(i - j).add(A[i][j]);
            }
        }

        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                A[i][j] = d.get(i - j).poll();
        return A;
    }
}
