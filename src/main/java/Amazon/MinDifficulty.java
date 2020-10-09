package Amazon;

import java.util.Arrays;

public class MinDifficulty {

    public int minDifficulty1(int[] A, int D) {
        int n = A.length, inf = Integer.MAX_VALUE, maxd;
        if (n < D) return -1;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; --i)
            dp[i] = Math.max(dp[i + 1], A[i]);
        for (int d = 2; d <= D; ++d) {
            for (int i = 0; i <= n - d; ++i) {
                maxd = 0;
                dp[i] = inf;
                for (int j = i; j <= n - d; ++j) {
                    maxd = Math.max(maxd, A[j]);
                    dp[i] = Math.min(dp[i], maxd + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }

    // DFS
    public int minDifficulty2(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;
        return dfs(D, 0, jobDifficulty);
    }

    private int dfs(int d, int len, int[] jobDifficulty){
        final int N = jobDifficulty.length;
        if(d == 0 && len == N) {
            return 0;
        }
        if(d == 0 || len == N) {
            return Integer.MAX_VALUE;
        }

        int curMax = jobDifficulty[len];
        int min = Integer.MAX_VALUE;

        for(int schedule = len; schedule < N; ++schedule){
            curMax = Math.max(curMax, jobDifficulty[schedule]);
            int temp = dfs(d - 1, schedule + 1, jobDifficulty);
            if(temp != Integer.MAX_VALUE)
                min = Math.min(min, temp + curMax);
        }

        return  min;
    }

    // DFS with memoization
    public int minDifficulty(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;

        int[][] memo = new int[N][D + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return dfs(D, 0, jobDifficulty, memo);
    }

    private int dfs(int d, int len, int[] jobDifficulty, int[][] memo){
        final int N = jobDifficulty.length;
        if(d == 0 && len == N) return 0;
        if(d == 0 || len == N) return Integer.MAX_VALUE;
        if(memo[len][d] != -1) return memo[len][d];

        int curMax = jobDifficulty[len];
        int min = Integer.MAX_VALUE;
        for(int schedule = len; schedule < N; ++schedule){
            curMax = Math.max(curMax, jobDifficulty[schedule]);
            int temp = dfs(d - 1, schedule + 1, jobDifficulty, memo);
            if(temp != Integer.MAX_VALUE)
                min = Math.min(min, temp + curMax);
        }

        return memo[len][d] = min;
    }
}
