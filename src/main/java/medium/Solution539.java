package medium;

import java.util.List;

public class Solution539 {
    public int findMinDifference(List<String> timePoints) {
        boolean[] buckets = new boolean[24 * 60];

        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;

        for (String s : timePoints) {
            int mins = toMinutes(s);
            first = Math.min(first, mins);
            last = Math.max(last, mins);

            if (buckets[mins]) return 0;
            buckets[mins] = true;
        }

        int prev = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < buckets.length; i++) {
            if (!buckets[i]) continue;
            if (prev != -1) {
                ans = Math.min(ans, i - prev);
            }
            prev = i;
        }
        ans = Math.min(first + 1440 - last, ans);
        return ans;
    }

    private int toMinutes(String s) {
        String split[] = s.split(":");
        int hour = Integer.valueOf(split[0]);
        int min = Integer.valueOf(split[1]);
        return hour * 60 + min;
    }
}
