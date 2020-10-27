package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution1429 {
    Map<Integer, Integer> freq = new HashMap<>();

    Queue<Integer> q = new LinkedList<>();

    public Solution1429(int[] nums) { //FirstUnique
        for (int x : nums)
            add(x);
    }

    public int showFirstUnique() {
        while (!q.isEmpty() && freq.get(q.peek()) > 1)
            q.poll();
        return q.isEmpty() ? -1 : q.peek();
    }

    public void add(int value) {
        freq.put(value, freq.getOrDefault(value, 0) + 1);
        q.offer(value);
    }
}
