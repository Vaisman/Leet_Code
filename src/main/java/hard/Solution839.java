package hard;

public class Solution839 {
    public int numSimilarGroups(String[] A) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null ) continue;
            dfs(A, i);
            res++;
        }
        return res;
    }

    private void dfs(String[] A, int j) {
        String str = A[j];
        A[j] = null;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == null ) continue;
            if (similar(str, A[i])) dfs(A, i);
        }
    }

    private boolean similar(String a, String b) {
        if (a.length() != b.length()) return false;
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
            if (cnt > 2) return false;
        }
        return cnt == 0 || cnt == 2;
    }
}
