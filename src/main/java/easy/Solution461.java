package easy;

public class Solution461 {
    public int hammingDistance(int x, int y) {
        int mask = 1;
        int c = x^y;
        int res = 0;
        while (c>0) {
            res += c & mask;
            c = c>>1;
        }
        return res;
    }
}
