package Amazon;

import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {
    private int f;
    private int[][] dp;
    final private long mod = 1_000_000_007L;

    public int numRollsToTarget(int d, int f, int target) {
        if (target < d || target > d * f) return 0;
        if (d == 1) return target <= f ? 1 : 0;

        this.f = f;
        dp = new int[d+1][target+1];
        for (int i = 2; i <= d; i++)
        {
            Arrays.fill(dp[i], -1);
        }
        int min = Math.min(f, target);
        for (int i = 1; i <= min; i++)
        {
            dp[1][i] = 1;
        }

        return dfs(d, target);
    }

    private int dfs(int d, int target)
    {
        long ans = 0;
        int max = Math.max(1, target-f);
        for (int i = target-1; i >= max; i--)
        {
            ans += (dp[d-1][i] == -1) ? dfs(d-1, i) : dp[d-1][i];
        }
        ans = ans % mod;
        dp[d][target] = (int)ans;
        return dp[d][target];
    }
}

