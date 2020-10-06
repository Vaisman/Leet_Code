package Amazon;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> outputList = new ArrayList<>();
        backtrack(outputList, "", 0, 0, n);
        return outputList;
    }

    public void backtrack(List<String> outputList, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            outputList.add(current);
            return;
        }
        if (open < max)
            backtrack(outputList, current + "(", open+1, close, max);
        if (close < open)
            backtrack(outputList, current + ")", open, close+1, max);
    }
}
