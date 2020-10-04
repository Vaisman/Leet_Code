package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList();
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        int m = 0;
        for (int[] curr : intervals) {
            start[m] = curr[0];
            end[m] = curr[1];
            m++;
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int j = 0;
        for(int i = 0; i < start.length; i++) {
            if(i == start.length - 1 || start[i+1] > end[i]) {
                list.add(new int[] {start[j] , end[i]});
                j = i + 1;
            }
        }
        int[][] ans = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            ans[k] = list.get(k);
        }
        return ans;
    }
}
