package medium;

import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] t) {
        if (t == null) return new int[] {};

        int[] res = new int[t.length];

        Stack<Integer> stack = new Stack<>();
        for (int i = t.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && t[i] >= t[stack.peek()])
                stack.pop();

            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return res;
    }
}
