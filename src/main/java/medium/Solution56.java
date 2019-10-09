package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import common.Interval;

public class Solution56 {
    public List<Interval> merge(List<Interval> intervals) {
        int n = intervals.size();
        int[] start = new int[n], end = new int[n];
        for (int i = 0; i < n; i ++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        List<Interval> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (j == n - 1 || end[j] < start[j + 1]) {
                list.add(new Interval(start[i], end[j]));
                i = j + 1;
            }
            j ++;
        }
        return list;
    }
}
