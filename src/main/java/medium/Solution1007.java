package medium;

public class Solution1007 {
     private int check(int x, int[] A, int[] B, int n) {
        int rotationsA = 0;
        int rotationsB = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] != x && B[i] != x) return -1;
            else if (A[i] != x) rotationsA++;
            else if (B[i] != x) rotationsB++;
        }
        return Math.min(rotationsA, rotationsB);
    }

    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rotations = check(A[0], B, A, n);
        if (rotations != -1 || A[0] == B[0]) {
            return rotations;
        }
        else {
            return check(B[0], B, A, n);
        }
    }
}
