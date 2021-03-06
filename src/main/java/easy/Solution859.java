package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution859 {
    public boolean buddyStrings(String A, String B) {
        if (A == null || A.length() < 2 || B == null || B.length() < 2 || A.length() != B.length()) return false;

        if (A.equals(B)) {
            int[] val = new int[26];
            for(int i = 0; i< A.length(); i++) {
                val[A.charAt(i) - 'a']++;
                if (val[A.charAt(i) - 'a'] > 1)
                    return true;
            }
        }

        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i)
            if (A.charAt(i) != B.charAt(i))
                dif.add(i);
        return dif.size() == 2 &&
                A.charAt(dif.get(0)) == B.charAt(dif.get(1)) &&
                A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
}
