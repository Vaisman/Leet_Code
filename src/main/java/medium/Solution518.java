package medium;

public class Solution518 {
    public int change(int amount, int[] coins) {
        Integer[][] ways = new Integer[coins.length][amount + 1];
        return changeWays(amount, coins, 0, ways);
    }

    private int changeWays(int amount, int[] coins, int idx, Integer[][] ways) {
        if (amount == 0) return 1;
        if (idx >= coins.length) return 0;
        if (ways[idx][amount] != null) return ways[idx][amount];

        int way1 = 0;
        if (amount >= coins[idx])
            way1 = changeWays(amount - coins[idx], coins, idx, ways);

        int way2 = changeWays(amount, coins, idx + 1, ways);
        ways[idx][amount] = way1 + way2;
        return way1 + way2;
    }
}
