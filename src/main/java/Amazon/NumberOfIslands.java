package Amazon;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {

        int islands = 0;
        int[] next = new int[]{0, 0};

        while (found(grid, next)) {
            dfs(grid, next[0], next[1]);
            islands++;
        }
        return islands;
    }

    private boolean found(char[][] grid, int[] next) {
        for (int i = next[0]; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    next[0] = i;
                    next[1] = j;
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (grid[row][col] == '1') {
            grid[row][col] = '0';

            if (row - 1 >= 0)
                dfs(grid, row - 1, col);
            if (row + 1 < grid.length)
                dfs(grid, row + 1, col);

            if (col - 1 >= 0)
                dfs(grid, row, col - 1);
            if (col + 1 < grid[0].length)
                dfs(grid, row, col + 1);
        }
    }
}
