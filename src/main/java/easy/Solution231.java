package easy;

public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n <=0) return false;
        return (n & n-1) == 0;
    }
}
