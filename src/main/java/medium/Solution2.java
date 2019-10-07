package medium;

import common.ListNode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode runner = new ListNode(0);
        ListNode head = runner;

        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {

            int sum = carry +
                    ((l1 != null) ? l1.val : 0) +
                    ((l2 != null) ? l2.val : 0);

            carry = sum / 10;

            ListNode curr = new ListNode(sum % 10);
            runner.next = curr;
            runner = runner.next;

            l1 = (l1 != null) ? l1.next : l1;
            l2 = (l2 != null) ? l2.next : l2;
        }

        return head.next;
    }
}
