package medium;

public class Solution1155 {

    public int numRollsToTarget(int d, int f, int target) {
        Integer[][] memo = new Integer[d + 1][target + 1];
        return helper(d, f, target, memo);
    }

    public int helper(int d, int f, int target, Integer[][] memo) {
        if (d == 0 || target <= 0) {
            return d == target ? 1 : 0;
        }
        if (memo[d][target] != null) {
            return memo[d][target];
        }
        memo[d][target] = 0;
        for (int i = 1; i <= f; i++) {
            memo[d][target] = (memo[d][target] + helper(d - 1, f, target - i, memo)) % 1000000007;
        }
        return memo[d][target];
    }
}
