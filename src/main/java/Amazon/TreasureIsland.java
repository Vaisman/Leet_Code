package Amazon;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
    public int treasureIsland(char[][] island) {
        if (island == null || island.length == 0) {
            return 0;
        }

        int steps = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        boolean[][] visited = new boolean[island.length][island[0].length];
        visited[0][0] = true;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // bfs
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinate coordinate = queue.poll();
                int x = coordinate.x;
                int y = coordinate.y;
                if (island[x][y] == 'X') return steps;

                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < island.length && newY >= 0 && newY < island[0].length &&
                            island[newX][newY] != 'D' && !visited[newX][newY]) {
                        queue.add(new Coordinate(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            steps++;
        }

        return 0;
    }

    @Test
    public void test() {
        char[][] island = new char[][]{
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'O', 'O'},
                {'X', 'D', 'D', 'O'}
        };
        int result = treasureIsland(island);
        System.out.println(String.format("%s (expect 5)", result));
        System.out.println(String.format("%s (expect 5)", findShortestRoute(island)));
    }

    class Coordinate {
          int x;
          int y;

          Coordinate(int x, int y) {
              this.x = x;
              this.y = y;
          }
      }

      //

    private int distance = Integer.MAX_VALUE;

    public int findShortestRoute(char[][] island) {
        if (island == null) {
            return -1;
        }
        boolean[][] visited = new boolean[island.length][island[0].length];
        dfs(island, 0, 0, visited, 0);

        return distance;
    }

    public void dfs(char[][] grid, int i, int j, boolean[][] visited, int levelDistance) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 'D' || visited[i][j]) {
            return;
        }
        if (grid[i][j] == 'X') {
            distance = Math.min(distance, levelDistance);
            return;
        }
        visited[i][j] = true;

        dfs(grid, i, j - 1, visited, levelDistance + 1); // back
        dfs(grid, i - 1, j, visited, levelDistance + 1);// up
        dfs(grid, i, j + 1, visited, levelDistance + 1);// forward
        dfs(grid, i + 1, j, visited, levelDistance + 1);// downward

        visited[i][j] = false;
    }
}