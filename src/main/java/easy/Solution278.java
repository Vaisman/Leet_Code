package easy;

public class Solution278 {
    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int start = 0, end = n;

        while (start < end) {
            int mid = start + (end-start) / 2;
            if (!isBadVersion(mid)) start = mid + 1;
            else end = mid;
        }

        return start;
    }
}
