package easy;

public class Solution942 {
    public int[] diStringMatch(String S) {
        int sol[] = new int[S.length() + 1];
        int upper = S.length();
        int lower = 0;
        for (int i = 0; i < S.length(); i++) {
            sol[i] = S.charAt(i) == 'I' ? lower++ : upper--;
        }
        sol[sol.length - 1] = upper;
        return sol;
    }
}
