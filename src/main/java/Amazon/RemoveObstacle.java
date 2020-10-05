package Amazon;

import org.junit.Test;

import java.util.*;

public class RemoveObstacle {

    int removeObstacle1(int numRows, int numColumns, List<List<Integer>> lot) {
        int[][] matrix = new int[numRows][numColumns];
        boolean[][] visited = new boolean[numRows][numColumns];
        int result = 0;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        for (int i = 0; i < lot.size(); i++) {
            List<Integer> sub = lot.get(i);
            for (int j = 0; j < sub.size(); j++) {
                matrix[i][j] = lot.get(i).get(j);
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                if (x < 0 || y < 0 || x >= numRows || y >= numColumns || matrix[x]
                        [y] == 0 || visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                if (matrix[x][y] == 9) {
                    return result;
                }
                for (int[] dir : dirs) {
                    int x_ = dir[0] + x;
                    int y_ = dir[1] + y;
                    queue.offer(new int[]{x_, y_});
                }
            }
            result++;
        }
        return -1;
    }

    @Test
    public void test() {
        List<Integer> list1 = Arrays.asList(1, 0, 0);
        List<Integer> list2 = Arrays.asList(1, 0, 0);
        List<Integer> list3 = Arrays.asList(1, 9, 1);
        List<List<Integer>> lot = new ArrayList<>();
        lot.add(list1);
        lot.add(list2);
        lot.add(list3);
        for (int i = 0; i < lot.size(); i++) {
            System.out.println(lot.get(i).get(0) + "," + lot.get(i).get(1) + "," + lot.get(i).get(2));
        }
        int numRows = 3;
        int numColumns = 3;
        System.out.println(removeObstacle1(numRows, numColumns, lot));
    }
}
