package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <=0) {
            return res;
        }

        dfs(res, "", 0, 0, n);
        return res;
    }

    void dfs(List<String> res, String curr, int left, int right, int count) {
        if (curr.length() == count*2) {
            res.add(curr);
            return;
        }

        if (left < count )
            dfs(res, curr + "(", left + 1, right, count);

        if (right < left)
            dfs(res, curr + ")", left, right + 1, count);
    }
}
