package hard;

import java.util.Arrays;

public class Solution1235 {
    static class Job implements Comparable<Job> {
        int start;
        int end;
        int profit;

        public Job(int s, int e, int p) {
            start = s;
            end = e;
            profit = p;
        }

        @Override
        public int compareTo(Job other) {
            return this.end - other.end;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int num = startTime.length;
        if (num == 0) {
            return 0;
        }
        int[] ans = new int[num];
        Job[] jobs = new Job[num];
        for (int i = 0; i < num; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
            ans[i] = 0;
        }

        Arrays.sort(jobs);
        int i, j;
        ans[0] = jobs[0].profit;
        int ret = Integer.MIN_VALUE;
        for (i = 1; i < num; i++) {
            ans[i] = Math.max(jobs[i].profit, ans[i - 1]);
            ret = Math.max(ret, ans[i]);
            for (j = i - 1; j >= 0; j--) {
                if (jobs[i].start >= jobs[j].end) {
                    ans[i] = Math.max(ans[i], ans[j] + jobs[i].profit);
                    ret = Math.max(ret, ans[i]);
                    break;
                }
            }
        }
        return ret;
    }
}
