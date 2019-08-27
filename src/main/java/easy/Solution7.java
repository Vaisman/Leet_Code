package easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution7 {

    public int reverse(int x) {
        long res = 0;
        while(x != 0) {
            res = res*10 + x % 10;
            if ((res > Integer.MAX_VALUE) || (res < Integer.MIN_VALUE))  {
                return 0;
            }
            x = x / 10;

        }
        return (int) res;
    }

    @Test
    public void test() {
        assertEquals(new Solution7().reverse(-123), -321 );
    }
}
