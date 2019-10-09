package medium;

import java.util.Arrays;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m <=0 || n <= 0) {
            return 0;
        }

        int []arr = new int[n];
        Arrays.fill(arr, 1);

        for (int i =1 ; i< m; i++ ) {
            for (int j = 1; j < n; j++) {
                arr[j] += arr[j-1] ;
            }
        }
        return arr[n-1];
    }
}
