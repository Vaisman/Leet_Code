package hard;

public class Solution1326 {
    //Very similar to 1024.Video Stitching problem
    //Greedy Approach
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];

        //sort the intervals according to start time
        for (int i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = i + ranges[i];
            arr[left] = Math.max(arr[left], right);
        }

        int count = 0;
        int reached = 0;
        int farCanReach = 0;

        for (int start = 0; start <= n && reached < n; ) {
            count++;

            while (start <= n && start <= reached) {
                farCanReach = Math.max(farCanReach, arr[start++]);
            }

            if (reached == farCanReach)
                return -1;

            reached = farCanReach;
        }

        return count;
    }
}
