package easy;

public class Solution204 {
    public int countPrimes(int n) {
        if (n <= 0) {
            return 0;
        }

        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
}