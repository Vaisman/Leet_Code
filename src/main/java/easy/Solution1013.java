package easy;

import java.util.Arrays;

public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        if (A == null || A.length < 3) {
            return false;
        }
        int sum = Arrays.stream(A).sum();
        int part = 0;
        int count = 0;

        if (sum % 3 != 0) {
            return false;
        }

        for (int a : A) {
            part += a;
            if (part != sum / 3) {
                continue;
            }
            else if (++count == 3) {
                return true;
            }
            part = 0; // reset part.
        }
        return false;
    }
}
