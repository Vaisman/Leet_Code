package easy;

import common.ListNode;

public class Solution21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode runner = dummy;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        while(l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                runner.next = l2;
                l2 = l2.next;
            }
            else {
                runner.next = l1;
                l1 = l1.next;
            }
            runner = runner.next;
        }

        if (l1 == null)
            runner.next = l2;
        if (l2 == null)
            runner.next = l1;


        return dummy.next;
    }
}
