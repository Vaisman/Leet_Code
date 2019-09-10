package easy;

import common.ListNode;

public class Solution206 {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        reverse(head, prev);
        return head;
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head.next == null)
              return head;

        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }

    public ListNode reverseList1(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}
