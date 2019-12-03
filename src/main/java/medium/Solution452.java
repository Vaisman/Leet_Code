package medium;

import java.util.Arrays;

public class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, (int[] a, int[] b) -> {
                    if(a[0] != b[0]) return a[0] - b[0];
                    return a[1] - b[1];
                }
        );

        int count = 1;
        int end = points[0][1];
        for(int i = 1; i < points.length; i++) {
            if(points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                end = points[i][1];
                count++;
            }
        }
        return count;
    }
}
