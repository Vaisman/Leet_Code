package medium;

import org.junit.Test;

import java.util.Stack;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() &&
                    nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }

        return res;
    }

    @Test
    public void test() {
        nextGreaterElements(new int[]{1,2,1});
    }
}
/*
i=5  i % nums.length=2 res=[0, 0, -1]
  stack=[2]
i=4  i % nums.length=1 res=[0, -1, -1]
i=3  i % nums.length=0 res=[2, -1, -1]
  stack=[1, 0]
i=2  i % nums.length=2 res=[2, -1, 2]
  stack=[1, 2]
  stack=[1]
i=1  i % nums.length=1 res=[2, -1, 2]
i=0  i % nums.length=0 res=[2, -1, 2]
 */