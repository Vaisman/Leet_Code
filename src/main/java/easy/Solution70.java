package easy;

public class Solution70 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;

        for(int k = 2; k < n; k++) {
            res[k] = res[k-1] + res[k-2];
        }
        return res[n-1];
    }
}
