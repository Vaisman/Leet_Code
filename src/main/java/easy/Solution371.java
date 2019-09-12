package easy;

public class Solution371 {
    public int getSum(int a, int b) {
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;
        return getSum(sum, carry);
    }
}
