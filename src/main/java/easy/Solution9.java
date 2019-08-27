package easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;
        while(x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    @Test
    public void test() {
        assertEquals(true, isPalindrome(121));
        assertEquals(false, isPalindrome(123));
    }
}
