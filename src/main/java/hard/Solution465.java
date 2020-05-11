package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution465 {
    public int minTransfers(int[][] transactions) {
        // calculate the balance
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] t : transactions) {
            map.put(t[0], map.getOrDefault(t[0], 0) - t[2]);
            map.put(t[1], map.getOrDefault(t[1], 0) + t[2]);
        }

        // pick up the non-zero balances
        List<Integer> list = new ArrayList<>();
        for (int v : map.values()) {
            if (v != 0) list.add(v);
        }

        // try all possibilites
        return backtrack(list, 0);
    }

    private int backtrack(List<Integer> list, int idx) {
        if (idx == list.size()) return 0;
        if (list.get(idx) == 0) return backtrack(list, idx + 1);

        int min = Integer.MAX_VALUE;
        int cur = list.get(idx);
        for (int i = idx + 1; i < list.size(); i++) {
            int next = list.get(i);
            if (cur * next < 0) {
                list.set(i, cur + next);
                min = Math.min(min, 1 + backtrack(list, idx + 1));
                list.set(i, next);
                if (cur + next == 0) break;
            }
        }
        return min;
    }
}
