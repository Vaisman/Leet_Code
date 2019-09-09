package easy;

import common.ListNode;

public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head.val == val) {
            head = head.next;
        }

        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr = curr.next;
            }
            else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return head;
    }
}

/*
Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
*/
