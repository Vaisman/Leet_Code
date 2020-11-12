package medium;

import org.junit.Test;

import java.util.Arrays;

public class Solution435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals);

        int prev = 0;
        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                if (intervals[prev][1] > intervals[i][1]) {
                    prev = i;
                }
                count++;
            } else {
                prev = i;
            }
        }

        return count;
    }

    @Test
    public void test() {
        eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}});
    }
}
