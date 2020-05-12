package hard;

import java.util.ArrayList;
import java.util.List;

public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int begin = newInterval[0];
        int end = newInterval[1];
        int n = intervals.length;

        int i = 0;
        List<int[]> res = new ArrayList<>();
        while(i < n && intervals[i][1] < begin) {
            res.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= end) {
            begin = Math.min(begin, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        res.add(new int[]{begin, end});

        while(i < n)
            res.add(intervals[i++]);

        int[][] ret = new int[res.size()][2];
        int tail = 0;
        for(int[] interval : res)
            ret[tail++] = interval;

        return ret;
    }
}
