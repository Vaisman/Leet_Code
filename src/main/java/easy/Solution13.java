package easy;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Solution13 {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> T = new HashMap();
        T.put('I', 1);
        T.put('V', 5);
        T.put('X', 10);
        T.put('L', 50);
        T.put('C', 100);
        T.put('D', 500);
        T.put('M', 1000);

        long res = T.get(s.charAt(s.length()-1));
        for(int i = s.length() - 2 ; i >= 0 ; i--) {
            if (T.get(s.charAt(i)) < T.get(s.charAt(i+1)))
                res -= T.get(s.charAt(i));
            else
                res += T.get(s.charAt(i));
            if (res > Integer.MAX_VALUE) {
                throw new RuntimeException("overflow");
            }
        }

        return (int) res;
    }

    @Test
    public void test() {
        // neg
        // empty
        // null
        // too big (int overflow)
        // memory overflow
        // invalid input IIIIIIIIV or VIIIIIIIIIII
    }
}
