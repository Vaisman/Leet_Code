package Amazon;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.

public class KClosestPointsToOrigin {

    /*
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] res = new int[K][2];
        while (K > 0) {
            res[--K] = pq.poll();
        }
        return res;
    }
     */
    int[][] points;

    public int[][] kClosest(int[][] points, int K) {
        this.points = points;
        work(0, points.length - 1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public void work(int i, int j, int K) {
        if (i >= j) return;
        int oi = i;
        int oj = j;
        int pivot = dist(ThreadLocalRandom.current().nextInt(i, j));

        while (i < j) {
            while (i < j && dist(i) < pivot) i++;
            while (i < j && dist(j) > pivot) j--;
            swap(i, j);
        }

        if (K <= i - oi + 1)
            work(oi, i, K);
        else
            work(i+1, oj, K - (i - oi + 1));
    }

    public int dist(int i) {
        return points[i][0] * points[i][0] + points[i][1] * points[i][1];
    }

    public void swap(int i, int j) {
        int t0 = points[i][0];
        int t1 = points[i][1];
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        points[j][0] = t0;
        points[j][1] = t1;
    }
}
