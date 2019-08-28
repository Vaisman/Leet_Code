package easy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class Solution20 {


    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            Character currLeft = stack.pop();

            boolean pop = validOne(currLeft, c,'(', ')') || validOne(currLeft, c, '[', ']') ||
                    validOne(currLeft, c,'{', '}');

            if (pop == false)
                return false;
        }
        return stack.isEmpty();
    }

    private boolean validOne(Character currLeft, Character currRight, Character left, Character right) {
        return currLeft == left && currRight== right;
    }

    @Test
    public void test() {
        assertTrue(isValid(""));
        assertTrue(isValid("()"));
        assertFalse(isValid(")"));
        assertFalse(isValid("!"));
    }
}
