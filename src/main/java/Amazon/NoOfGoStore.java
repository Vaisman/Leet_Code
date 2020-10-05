package Amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoOfGoStore {

    public int numberAmazonGoStores(int rows, int column, List<List<Integer>> grid) {
        // validate input parameters
        if (rows <= 0 || column <= 0 || grid == null || grid.size() != rows) {
            return 0;
        }
        // convert to array to for constant access
        int[][] map = new int[rows][column];
        int row = 0;
        int col = 0;
        for (List<Integer> lrow : grid) {
            for (int lcol : lrow) {
                map[row][col++] = lcol;
            }
            row++;
            col = 0;
        }
        // run dfs and count clusters
        int count = 0;
        for (row = 0; row < map.length; row++) {
            for (col = 0; col < map[row].length; col++) {
                if (map[row][col] == 1) {
                    count++;
                    dfs(map, row, col);
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] != 1) {
            return;
        }
        grid[row][col] = 2; // mark as visited
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
    }

    @Test
    public void test() {
        List<List<Integer>> in = new ArrayList<>();
        List<Integer> i1 = Arrays.asList(1, 1, 0, 0);
        List<Integer> i2 = Arrays.asList(0, 0, 1, 0);
        List<Integer> i3 = Arrays.asList(0, 0, 0, 0);
        List<Integer> i4 = Arrays.asList(1, 0, 1, 1);
        List<Integer> i5 = Arrays.asList(1, 1, 1, 1);
        in.addAll(Arrays.asList(i1, i2, i3, i4, i5));
        System.out.println(new NoOfGoStore().numberAmazonGoStores(5, 4, in));
    }
}