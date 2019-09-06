package easy;

public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int left = 1;
        int right = x;
        int res = 0;

        while (left <= right) {
            int mid = (left + right ) / 2;

            if (mid <= x / mid) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}
