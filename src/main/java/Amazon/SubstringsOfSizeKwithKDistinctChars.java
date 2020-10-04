package Amazon;

import org.junit.Test;

import java.util.*;

public class SubstringsOfSizeKwithKDistinctChars {

    public static Set<String> uniqueSubstringSizeK(String s, int k) {
        Set<String> set = new HashSet<>();
        int[] ch = new int[26];
        int lo = 0;
        int hi = 0;
        while (lo <= hi && hi < s.length()) {
            ch[s.charAt(hi) - 'a']++;
            while (ch[s.charAt(hi) - 'a'] != 1) {
                ch[s.charAt(lo) - 'a']--;
                lo++;
            }
            if (hi - lo + 1 == k) {
                set.add(s.substring(lo, hi + 1));
                ch[s.charAt(lo) - 'a']--;
                lo++;
            }
            hi++;
        }

        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");

        }
        System.out.println();
        return set;
    }


    @Test
    public void test() {
        uniqueSubstringSizeK("abcabc", 3);
        uniqueSubstringSizeK("abacab", 3);
        uniqueSubstringSizeK("awaglknagawunagwkwagl", 4);
    }

}
