package easy;

import common.ListNode;

public class Solution234 {
    ListNode left = null;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return helper(head);
    }

    public boolean helper(ListNode right) {
        if (right == null) {
            return true;
        }

        boolean res = helper(right.next);
        if (res != true) {
            return false;
        }
        boolean y = (left.val == right.val);
        left = left.next;
        return y;
    }
}
