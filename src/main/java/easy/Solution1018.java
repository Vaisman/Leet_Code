package easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        if (A == null || A.length == 0) {
            return Collections.emptyList();
        }

        int k = 0;
        List<Boolean> res = new ArrayList<>();
        for (int a : A) {
            k = (k << 1 | a) % 5; // left shift k by 1 bit and plus current element a is the binary number.
            res.add(k == 0);
        }
        return res;
    }
}
