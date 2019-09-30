package easy;

import java.util.Arrays;

import org.junit.Test;

public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return -1;
        }

        int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }

        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.println("1: " + dp[i - 1][j] + "  " + costs[i + j - 1][0]);
                System.out.println("2: " + dp[i][j - 1] + "  " + costs[i + j - 1][1]);

                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0],
                                    dp[i][j - 1] + costs[i + j - 1][1]);
                System.out.println("min: " + dp[i][j] + "\n");

            }
        }
        return dp[N][N];
    }

    // follow up solution
    public int twoCitySchedCostSort(int[][] costs) {
        Arrays.sort(costs, (int[] a, int[] b) -> {return (a[1] - a[0]) - (b[1] - b[0]);});

        int cost = 0;
        for (int i = 0; i < costs.length / 2; i++) {
            cost += costs[i][1] + costs[costs.length-i-1][0];
        }
        return cost;
    }

    public int twoCitySchedCostFa(int[][] costs) {
        int[] diff = new int[costs.length];
        int sum = 0;
        for(int i=0; i<costs.length; i++) {
            diff[i] = costs[i][0] - costs[i][1];
            sum += costs[i][0];
        }

        Arrays.sort(diff);

        for(int i=diff.length/2; i < diff.length; i++) {
            sum -= diff[i];
        }
        return sum;
    }

    @Test
    public void test() {
        int[][] n = new int[4][2];
        n[0][0] = 10;   n[0][1] = 20;
        n[1][0] = 30;   n[1][1] = 200;
        n[2][0] = 400;  n[2][1] = 50;
        n[3][0] = 30;   n[3][1] = 20;
        twoCitySchedCost(n);
    }
}
