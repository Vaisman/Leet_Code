package easy;

public class Solution258 {
    public int addDigits(int num) {
        if (num <= 9)
            return num;

        int res = 0;
        while (num > 0) {
            res += num % 10;
            num = num / 10;
        }
        return addDigits(res);
    }

    int addDigits1(int num) {
        return 1 + (num - 1) % 9;
    }
}
