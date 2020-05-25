package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1245 {
    int[] best = new int[]{-1, -1};
    Map<Integer, List<Integer>> adj = new HashMap<>();

    public int treeDiameter(int[][] E) {
        buildAdj(E);

        dfs(0, -1, 0);
        dfs(best[1], -1, 0);

        return best[0];
    }

    private void dfs(int c, int p, int len) {
        if (len > best[0]) {
            best = new int[]{len, c};
        }

        for (int e: adj.get(c)) {
            if (e != p) {
                dfs(e, c, len + 1);
            }
        }
    }

    // Standard method to build adjacency list.
    private void buildAdj(int[][] E) {
        for (int[] e: E) {
            if (!adj.containsKey(e[0])) {
                adj.put(e[0], new ArrayList<>());
            }
            if (!adj.containsKey(e[1])) {
                adj.put(e[1], new ArrayList<>());
            }

            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
    }
}
