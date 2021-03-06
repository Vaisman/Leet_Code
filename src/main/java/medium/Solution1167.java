package medium;

import java.util.PriorityQueue;

public class Solution1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : sticks) {
            pq.offer(s);
        }

        int sum = 0;
        while (pq.size() > 1) {
            int two = pq.poll() + pq.poll();
            sum += two;
            pq.offer(two);
        }

        return sum;
    }
}
