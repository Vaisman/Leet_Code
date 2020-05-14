package hard;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution317 {
    private int min = Integer.MAX_VALUE;
    private int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];

        int start = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    bfs(grid, r, c, start--, dist);
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void bfs(int[][] grid, int r, int c, int start, int[][] dist) {
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{r, c});
        int level = 0;
        min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] p = queue.poll();
                for (int i = 0; i < dir.length; i++) {
                    int x = p[0] + dir[i][0];
                    int y = p[1] + dir[i][1];

                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == start) {
                        grid[x][y]--;
                        dist[x][y] += level;
                        min = Math.min(min, dist[x][y]);
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }

    @Test
    public void test(){
        shortestDistance(new int[][]{{1,0,2,0,1},
                                     {0,0,0,0,0},
                                     {0,0,1,0,0}});
    }
}
