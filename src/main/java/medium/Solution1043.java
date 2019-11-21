package medium;

public class Solution1043 {
    private int dfs(int[] A, int K, int start) {
        int n = A.length;
        if (start >= n) return 0;

        int maxSum = 0, maxEle = 0;
        for (int i = start; i < Math.min(n, start + K); i++) {
            maxEle = Math.max(maxEle, A[i]);
            maxSum = Math.max(maxSum,
                              maxEle * (i - start + 1) + dfs(A, K, i + 1));
        }
        return maxSum;
    }

    public int maxSumAfterPartitioning(int[] A, int K) {
        return dfs(A, K, 0);
    }
}
