package easy;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        // input validation

        boolean[][] visited = new boolean[R][C];
        int[][] result = new int[R * C][2];
        int i = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r0, c0});

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            if (r < 0 || r >= R || c < 0 || c >= C) {
                continue;
            }
            if (visited[r][c]) {
                continue;
            }

            result[i] = cell;
            i++;
            visited[r][c] = true;

            queue.offer(new int[]{r, c - 1});
            queue.offer(new int[]{r, c + 1});
            queue.offer(new int[]{r - 1, c});
            queue.offer(new int[]{r + 1, c});
        }
        return result;
    }

    public int[][] allCellsDistOrder1(int R, int C, int r0, int c0) {
        int[] counter = new int[R + C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int dist = Math.abs(r - r0) + Math.abs(c - c0);
                counter[dist + 1]++;
            }
        }

        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[i - 1];
        }

        int[][] res = new int[R * C][];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int dist = Math.abs(r - r0) + Math.abs(c - c0);
                res[counter[dist]] = new int[]{r, c};
                counter[dist]++;
            }
        }

        return res;
    }
}
