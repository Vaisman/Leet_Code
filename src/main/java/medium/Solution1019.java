package medium;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> A = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            A.add(node.val);

        int[] res = new int[A.size()];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < A.size(); ++i) {
            while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
                res[stack.pop()] = A.get(i);
            stack.push(i);
        }

        return res;
    }
}
