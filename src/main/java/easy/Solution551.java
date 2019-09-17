package easy;

public class Solution551 {
    public boolean checkRecord(String s) {
        int a = 0;
        int l1 = 0;
        int l2 = 0;
        for(char c :s.toCharArray()) {
            if (c == 'P') {
                l1 = 0;
                l2 = 0;
                continue;
            }

            if (c == 'A') {
                a++;
                l1 = 0;
                l2 = 0;
                continue;
            }

            if (c== 'L') {
                if (l1 == 0) {
                    l1++;
                }
                else {
                    l2++;
                    if (l2 > 1)
                        return false;
                }
            }
        }
        return (a < 2);
    }
}

/*
doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
*/