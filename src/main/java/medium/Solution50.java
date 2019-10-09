package medium;

public class Solution50 {
    public double myPow(double x, int n) {
        boolean isNegPow = false;

        if (n < 0) {
            x = 1 / x;
            isNegPow = true;
            n = -(n + 1); // Avoid overflow when pow == MIN_VALUE
        }

        double ans = 1, tmp = x;

        while (n != 0) {
            if (n % 2 == 1) {
                ans *= tmp;
            }

            tmp *= tmp;
            n /= 2;
        }

        if (isNegPow) {
            ans *= x;
        }

        return ans;
    }
}
