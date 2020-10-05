package Amazon;

import org.junit.Test;

import java.util.*;

public class MinimumHours {
    private static final int ACTIVE_SERVER = 1;
    private static final int NON_ACTIVE_SERVER = 0;
    private static final int[][] GRID_DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    int minimumHours(int rows, int columns, List<List<Integer>> grid) {
        // input validation
        if (rows <= 0 || columns <= 0 ||
                grid == null || grid.size() == 0 || grid.get(0).size() == 0) {
            return 0;
        }

        // memoize active servers, runtime O(n*m) memory O(n*m)
        Queue<ServerPosition> activeServers = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid.get(i).get(j) == ACTIVE_SERVER) {
                    activeServers.add(new ServerPosition(i, j));
                }
            }
        }

        long daysToUpdate = 0;

        // run BFS by active servers, runtime O(n * m) memory O(n * m)
        while (!activeServers.isEmpty()) {
            boolean atLeastOneUpdated = false;

            long activeServersCount = activeServers.size();
            for (long i = 0; i < activeServersCount; i++) {
                ServerPosition serverPosition = activeServers.poll();
                for (int[] direction : GRID_DIRECTIONS) {
                    int x = serverPosition.i + direction[0];
                    int y = serverPosition.j + direction[1];
                    if (isPositionInGridBounds(x, y, rows, columns) && isServerNonActive(x, y, grid)) {
                        grid.get(x).set(y, ACTIVE_SERVER);
                        activeServers.add(new ServerPosition(x, y));
                        atLeastOneUpdated = true;
                    }
                }
            }

            if (atLeastOneUpdated) {
                daysToUpdate++;
                // TODO is daysToUpdate > Integer.MAX_VALUE exceptional case?
            }
        }

        return daysToUpdate > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) daysToUpdate;
    }

    private class ServerPosition {
        private int i;
        private int j;

        ServerPosition(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private boolean isServerNonActive(int i, int j, List<List<Integer>> grid) {
        return grid.get(i).get(j) == NON_ACTIVE_SERVER;
    }

    private boolean isPositionInGridBounds(int i, int j, int n, int m) {
        return !(i < 0 || j < 0 || i >= n || j >= m);
    }

    @Test
    public void test1() {
        List<List<Integer>> grid = new ArrayList<>();
        grid.add(Arrays.asList(0,1,1,0,1));
        grid.add(Arrays.asList(0,1,0,1,0));
        grid.add(Arrays.asList(0,0,0,0,1));
        grid.add(Arrays.asList(0,1,0,0,0));
        minimumHours(4, 5, grid);
    }
}
