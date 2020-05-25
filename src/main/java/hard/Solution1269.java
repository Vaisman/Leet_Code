package hard;

import java.util.Arrays;

public class Solution1269 {

    public int numWays(int steps, int arrLen) {
        double[][] memo = new double[steps/2+1][steps+1];
        for (double[] m : memo) {
            Arrays.fill(m, -1);
        }
        return (int) helper(memo, 0, arrLen, steps);
    }

    private double helper(double[][] memo, int index, int arrLen, int remainingSteps) {
        if (index==0 && remainingSteps==0) {
            return 1;
        }
        if (index<0 || index>=arrLen || remainingSteps==0 || index>remainingSteps) {
            return 0;
        }
        if (memo[index][remainingSteps] != -1) {
            return memo[index][remainingSteps];
        }
        double moveRight = helper(memo, index + 1, arrLen, remainingSteps - 1);
        double moveLeft = helper(memo, index - 1, arrLen, remainingSteps - 1);
        double stay = helper(memo, index, arrLen, remainingSteps - 1);
        memo[index][remainingSteps] = moveRight + moveLeft + stay;
        return memo[index][remainingSteps];
    }
}
