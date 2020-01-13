package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution1197 {
    private static final int[] d = {2, 1, 2, -1, 2, -1, -2, 1, 2}; // 8 possible moves.
    private static final int p = 601;

    public int minKnightMoves(int x, int y) {
        // Use the symmetric property.
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        Set<Integer> seen = new HashSet<>(q);

        for (int steps = 0; !q.isEmpty(); ++steps) {
            for (int sz = q.size(); sz > 0; --sz) {
                int i = q.peek() / p;
                int j = q.poll() % p;

                if (i == x && j == y)
                    return steps;
                for (int k = 0; k < 8; ++k) {
                    int r = i + d[k], c = j + d[k + 1];
                    if (r >= -2 && c >= -2 && seen.add(r * p + c)) {
                        q.offer(r * p + c);
                    }
                }
            }
        }
        return -1;
    }

    //
    public int minKnightMoves1(int x, int y) {
        Map<String, Integer> map = new HashMap<>();
        // base case
        map.put("0,0", 0);
        map.put("1,0", 3);
        map.put("1,1", 2);
        map.put("2,0", 2);
        return helper2(x, y, map);
    }

    private int helper2(int x, int y, Map<String, Integer> map) {
        // Sysmetrical of axis
        x = Math.abs(x);
        y = Math.abs(y);
        // Sysmetrical of diagonal
        String s = x + "," + y;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int temp = Math.min(helper2(x - 2, y - 1, map), helper2(x - 1, y - 2, map)) + 1;
        map.put(s, temp);
        return temp;
    }
}
