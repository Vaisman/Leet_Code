package medium;

public class Solution1254 {
    public int closedIsland(int[][] grid) {
        int res = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) res++;
                }
            }
        }

        return res;
    }

    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private boolean dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }

        if (grid[x][y] == 1) {
            return true;
        }

        grid[x][y] = 1;

        boolean res = true;
        for (int[] d : dir) {
            res = res & dfs(grid, x + d[0], y + d[1]);
        }

        return res;
    }
}
