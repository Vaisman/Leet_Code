package medium;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1219 {
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans = Math.max(ans, dfs(grid, i, j, 0));
            }
        }
        return ans;
    }

    private static final int[] d = {0, 1, 0, -1, 0};
    private int dfs(int[][] g, int i, int j, int sum) {
        if (i < 0 || i >= g.length || j < 0 || j >= g[0].length || g[i][j] == 0 || g[i][j] > 100)
            return sum;
        sum += g[i][j];
        g[i][j] += 1000;
        int mx = 0;
        for (int k = 0; k < 4; k++) {
            mx = Math.max(mx, dfs(g, i + d[k], j + d[k + 1], sum));
        }
        g[i][j] -= 1000;
        return mx;
    }

    public int getMaximumGold1(int[][] grid) {
        int ans = 0, m = grid.length, n = grid[0].length;
        int[][] oneCellTrace = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0, goldCellId = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    oneCellTrace[i][j] = 1 << goldCellId++;
                    q.offer(new int[]{i, j, grid[i][j], oneCellTrace[i][j]});
                }
            }
        }

        while (!q.isEmpty()) {
            int i = q.peek()[0];
            int j = q.peek()[1];
            int sum = q.peek()[2];
            int trace = q.poll()[3];
            ans = Math.max(sum, ans);

            for (int k = 0; k < 4; ++k) {
                int r = i + d[k], c = j + d[k + 1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] > 0
                        && (trace & oneCellTrace[r][c]) == 0) {
                    q.offer(new int[]{r, c, sum + grid[r][c], trace | oneCellTrace[r][c]});
                }
            }
        }
        return ans;
    }
}
