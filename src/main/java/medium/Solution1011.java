package medium;

public class Solution1011 {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0;
        for (int w: weights) {
            sum += w;
        }
        int lo = sum/D;
        int hi = sum;

        while (lo < hi) {
            int mid = (lo+hi)/2;
            if (isValid(weights, D, mid, sum)) {
                //decrease hi
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }

    public boolean isValid(int[] weights, int D, int limit, int sum) {
        int index = 0;
        int curLimit = limit;
        int curSum = 0;
        while (D > 0 && index < weights.length) {
            if (curLimit - weights[index] >= 0) {
                curLimit -= weights[index];
                curSum += weights[index];
                index += 1;
            } else {
                curLimit = limit;
                D--;
            }
        }
        return curSum == sum;
    }
}
