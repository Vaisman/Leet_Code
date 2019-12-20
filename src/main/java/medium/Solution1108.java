package medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1108 {
    final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    final int VISITED = -1;

    public int maximumMinimumPath(int[][] A) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        pq.add(new int[]{A[0][0], 0, 0});

        int minScore = A[0][0];
        A[0][0] = VISITED; // visited

        int n = A.length;
        int m = A[0].length;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int i = top[1];
            int j = top[2];
            minScore = Math.min(minScore, top[0]);

            if (i == n - 1 && j == m - 1) {
                return minScore;
            }

            for (int[] d : DIRECTIONS) {
                int newi = d[0] + i;
                int newj = d[1] + j;

                // in bounds and not visited
                if (newi >= 0 && newi < n && newj >= 0 && newj < m && A[newi][newj] >= 0) {
                    pq.add(new int[]{A[newi][newj], newi, newj});
                    A[newi][newj] = VISITED;
                }
            }
        }

        return -1; // shouldn't get here
    }
}
