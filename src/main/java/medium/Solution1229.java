package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for (int[] s : slots1) {
            if (s[1] - s[0] >= duration)
                pq.offer(s);
        }

        for (int[] s : slots2) {
            if (s[1] - s[0] >= duration)
                pq.offer(s);
        }

        while (pq.size() > 1) {
            if (pq.poll()[1] >= pq.peek()[0] + duration)
                return Arrays.asList(pq.peek()[0], pq.peek()[0] + duration);
        }
        return Arrays.asList();
    }
}
