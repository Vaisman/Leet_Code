package Amazon;

import org.junit.Test;

import java.util.*;

public class MinimumDays {

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        if (rows == 0 && columns == 0 || grid == null) {
            return 0;
        }
        Queue<Point> queue = new ArrayDeque<>();
        int outOfDateCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == 0) {
                    outOfDateCount++;
                } else {
                    queue.add(new Point(i, j));
                }
            }
        }
        int minimumDays = 0;
        while (!queue.isEmpty()) {
            minimumDays++;
            for (int i = 0; i < queue.size(); i++) {
                Point point = queue.poll();
                // set its neighbors to 1 if its neighbor is 0
                if (point.x - 1 >= 0) {
                    if (grid.get(point.x - 1).get(point.y) == 0) {
                        grid.get(point.x - 1).set(point.y, 1);
                        outOfDateCount--;
                        queue.add(new Point(point.x - 1, point.y));
                    }
                }
                if (point.x + 1 < rows) {
                    if (grid.get(point.x + 1).get(point.y) == 0) {
                        grid.get(point.x + 1).set(point.y, 1);
                        outOfDateCount--;
                        queue.add(new Point(point.x + 1, point.y));
                    }
                }
                if (point.y - 1 >= 0) {
                    if (grid.get(point.x).get(point.y - 1) == 0) {
                        grid.get(point.x).set(point.y - 1, 1);
                        outOfDateCount--;
                        queue.add(new Point(point.x, point.y - 1));
                    }
                }
                if (point.y + 1 < columns) {
                    if (grid.get(point.x).get(point.y + 1) == 0) {
                        grid.get(point.x).set(point.y + 1, 1);
                        outOfDateCount--;
                        queue.add(new Point(point.x, point.y + 1));
                    }
                }
            }
            if (outOfDateCount == 0) {
                return minimumDays;
            }
        }
        return -1;
    }

    /*

     */
    int minimumDays1(int rows, int columns, List<List<Integer> > grid)
    {
        // WRITE YOUR CODE HERE
        int[][] array = new int[grid.size()][];
        for (int i = 0; i < array.length; i++) {
            array[i] = new int[grid.get(i).size()];
        }
        for(int i=0; i<grid.size(); i++){
            for (int j = 0; j < grid.get(i).size(); j++) {
                array[i][j] = grid.get(i).get(j);
            }
        }
        return minDays(array);
    }

    // METHOD SIGNATURE ENDS
    private static int minDays(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int target = grid.length * grid[0].length;
        int cnt = 0, res = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[] {i,j});
                    cnt++;
                }
            }
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            if(cnt == target)
                return res;
            for(int i=0;i<size;i++) {
                int[] cur = q.poll();
                for(int[] dir : dirs) {
                    int ni = cur[0] + dir[0];
                    int nj = cur[1] + dir[1];
                    if(ni >=0 && ni < grid.length && nj >=0 && nj < grid[0].length && grid[ni][nj] == 0) {
                        cnt++;
                        q.offer(new int[] {ni, nj});
                        grid[ni][nj] = 1;
                    }
                }
            }
            res++;
        }
        return -1;
    }

    static int  minimumDays3(int rows, int columns, List<java.util.List<Integer> > grid)
    {
        int countOfDay = 0;
        int countOfNewUpdateServer = 0;

        boolean[][] alreadyUpdatedServer = new boolean[rows][columns];
        int alreadyUpdatedServerCount = 0;

        do {

            countOfNewUpdateServer = 0;
            int[][] newUpdatedServer = new int[rows][columns];
            for (int j = 0; j < rows; j++) {
                for (int i = 0; i < columns; i++) {
                    if (!alreadyUpdatedServer[j][i] && grid.get(j).get(i) == 1) {
                        alreadyUpdatedServer[j][i] = true;
                        alreadyUpdatedServerCount++;

                        if (j > 0 && grid.get(j - 1).get(i) == 0 && !alreadyUpdatedServer[j - 1][i] ) {
                            newUpdatedServer[j-1][i] = 1;
                        }

                        if (j < grid.size() - 1 && grid.get(j + 1).get(i) == 0 && !alreadyUpdatedServer[j + 1][i]) {
                            newUpdatedServer[j+1][i] = 1;
                        }

                        if (i > 0 && grid.get(j).get(i - 1) == 0 && !alreadyUpdatedServer[j][i - 1]) {
                            newUpdatedServer[j][i-1] = 1;
                        }

                        if (i < grid.get(j).size() - 1 && grid.get(j).get(i + 1) == 0 && !alreadyUpdatedServer[j][i + 1]) {
                            newUpdatedServer[j][i+1] = 1;
                        }
                    }
                }
            }

            for (int j = 0; j < rows; j++) {
                for (int i = 0; i < columns; i++) {
                    if (newUpdatedServer[j][i] == 1) {
                        countOfNewUpdateServer++;
                        grid.get(j).set(i, 1);
                    }
                }
            }

            if (countOfNewUpdateServer > 0) {
                countOfDay++;
            }
        } while (countOfNewUpdateServer > 0);

        if (alreadyUpdatedServerCount != rows * columns) {
            return -1;
        } else {
            return countOfDay;
        }
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
        System.out.println(minimumDays(5, 4, in));
        System.out.println(minimumDays1(4, 5, in));
    }

    @Test
    public void test1() {
        System.out.println(minimumDays3(4,5 , Arrays.asList(
                Arrays.asList(0,1,1,0,1),
                Arrays.asList(0,1,0,1,0),
                Arrays.asList(0,0,0,0,1),
                Arrays.asList(0,1,0,0,0))));

        System.out.println(minimumDays3(1,1 , Arrays.asList(
                Arrays.asList(0))));

        System.out.println(minimumDays3(5,5 , Arrays.asList(
                Arrays.asList(1,0,0,0,0),
                Arrays.asList(0,1,0,0,0),
                Arrays.asList(0,0,1,0,0),
                Arrays.asList(0,0,0,1,0),
                Arrays.asList(0,0,0,0,1))));

        System.out.println(minimumDays3(5,6 , Arrays.asList(
                Arrays.asList(0,0,1,0,0,0),
                Arrays.asList(0,0,0,0,0,0),
                Arrays.asList(0,0,0,0,0,1),
                Arrays.asList(0,0,0,0,0,0),
                Arrays.asList(0,1,0,0,0,0))));
    }
}