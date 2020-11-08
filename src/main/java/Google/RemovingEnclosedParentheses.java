package Google;

import org.junit.Test;

public class RemovingEnclosedParentheses {
    public String removeParentheses(String s) {
        int n = s.length();
        int count = 0;
        while (count < n && s.charAt(count) == '(' && s.charAt(n - count - 1) == ')') {
            count++;
        }

        int balance = 0;
        for (int i = count; i < n - count; i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else if (s.charAt(i) == ')') {
                if (balance == 0) {
                    count--;
                } else {
                    balance--;
                }
            }
        }

        return s.substring(count, n - count);
    }

    @Test
    public void tst() {
        // removeParentheses("(((a)))");
        removeParentheses("((a)(bcd)(e))");
    }
}
