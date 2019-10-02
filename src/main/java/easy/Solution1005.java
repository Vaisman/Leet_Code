package easy;

import java.util.PriorityQueue;

public class Solution1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int x: A)
            pq.add(x);

        while(K-->0)
            pq.add(-pq.poll());

        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += pq.poll();
        }
        return sum;
    }
}
