package Amazon;

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

public class MaxOfMinAltitudes {

    public static int maximumMinimumPath(int[][] A) {
        final int[][] DIRS = { { 1, 0 }, { 0, 1 } };
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.add(new int[] { A[0][0], 0, 0 });
        int maxscore = Integer.MAX_VALUE;
        A[0][0] = -1; // visited
        boolean ignore = true;
        boolean targetFound = false;

        while (!pq.isEmpty() && !targetFound) {
            int[] top = pq.poll();
            int i = top[1], j = top[2], n = A.length, m = A[0].length;
            // INGORING THE START
            if (!ignore) {
                maxscore = Math.min(maxscore, top[0]);
            }
            ignore = false;
            for (int[] d : DIRS) {
                int newi = d[0] + i, newj = d[1] + j;

                if (newi == n - 1 && newj == m - 1) {
                    // EXIT ONCE TARGET FOUND
                    targetFound = true;
                    break;
                }

                if (newi >= 0 && newi < n && newj >= 0 && newj < m && A[newi][newj] >= 0) {
                    pq.add(new int[] { A[newi][newj], newi, newj });
                    A[newi][newj] = -1;
                }
            }
        }
        return maxscore;
    }

    @Test
    public void test() {
        System.out.println(maximumMinimumPath(new int[][] {{5,1},{4,5}}));
        System.out.println(maximumMinimumPath(new int[][] {{1,2,3},{4,5,1}}));
    }
}