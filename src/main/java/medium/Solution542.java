package medium;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dirOffsets = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            //Visit adjacent cells in all four directions.
            for (int[] offset : dirOffsets) {
                int r = cell[0] + offset[0];
                int c = cell[1] + offset[1];
                if (r < 0 || r >= m || c < 0 || c >= n || visited[r][c]) {
                    continue;
                }
                //Add 1 to the distance of the adjacent cell of current cell.
                matrix[r][c] = matrix[cell[0]][cell[1]] + 1;
                visited[r][c] = true;
                //Add it to the queue so that distance can be calculated to it's neighbours.
                queue.offer(new int[]{r, c});
            }
        }
        return matrix;
    }

    @Test
    public void test(){
        updateMatrix(new int[][]{{0,0,0},{0,1,0},{1,1,1}});
    }
}
