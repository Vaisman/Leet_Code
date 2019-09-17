package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        if (findNums == null || findNums.length == 0 || nums == null || nums.length == 0)
            return new int[]{};

        int[] res = new int[findNums.length];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            while (!stack.empty() && n > stack.peek())
                map.put(stack.pop(), n);
            stack.push(n);
        }

        while (!stack.empty())
            map.put(stack.pop(), -1);

        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }
        return res;
    }
}
