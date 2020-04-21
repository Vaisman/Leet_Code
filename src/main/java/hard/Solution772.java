package hard;

import java.util.Stack;

public class Solution772 {
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");
        Stack<Integer> stack = new Stack<>();

        char sign = '+';
        for(int i = 0 ; i < s.length();) {
            char c = s.charAt(i);
            if (c == '(') {
                // find the block and use the recursive to solve
                int l = 1;
                int j = i+1;
                while (j < s.length() && l > 0) {
                    if(s.charAt(j) == '(') l ++;
                    else if(s.charAt(j) == ')') l --;
                    j++;
                }
                int blockValue = calculate(s.substring(i + 1, j-1));
                i = j;
                if (sign == '+') {
                    stack.push(blockValue);
                } else if (sign == '-') {
                    stack.push(-blockValue);
                } else if (sign == '*') {
                    stack.push(stack.pop() * blockValue);
                } else if (sign == '/') {
                    stack.push(stack.pop() / blockValue);
                }
            } else if (Character.isDigit(c)) {
                int j = i;
                int value = 0;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    value = 10 * value + (s.charAt(j) - '0');
                    j++;
                }
                i = j;
                if (sign == '+') {
                    stack.push(value);
                } else if (sign == '-') {
                    stack.push(-value);
                } else if (sign == '*') {
                    stack.push(stack.pop() * value);
                } else if (sign == '/') {
                    stack.push(stack.pop() / value);
                }
            } else {
                sign = c;
                i++;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
