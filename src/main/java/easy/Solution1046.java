package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1046 {
    public int lastStoneWeight(int[] stones) {
        if (null == stones || stones.length == 0)
            return 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i: stones)
            pq.offer(i);

        while (pq.size() >= 2) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            if (s1 != s2)
                pq.offer(s1 - s2);
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }
}
