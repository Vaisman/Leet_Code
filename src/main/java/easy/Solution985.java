package easy;

public class Solution985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        // input validation

        int sum = 0, i = 0;
        for (int a : A) {
            if (a % 2 == 0) sum += a ;
        } // sum of even #s.

        int[] ans = new int[queries.length];
        for (int[] q : queries) {
            if (A[q[1]] % 2 == 0) { sum -= A[q[1]]; } // from 1) and 2)
            A[q[1]] += q[0];
            if (A[q[1]] % 2 == 0) { sum += A[q[1]]; } // from 2) and 3)
            ans[i++] = sum;
        }

        return ans;
    }
}
