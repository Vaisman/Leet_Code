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

    /* Carry is at most 1.
     * If the current node is 9, even if there is a carry, the previous node may get affected.
     * If the current node is not 9, even if there is a carry after this, the previous node will not get affected.
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        if(len1 < len2){ // swap l1 and l2 to make sure l1 is the longer one
            ListNode tmp = l1; l1 = l2; l2 = tmp;
        }

        int diff = Math.abs(len1-len2);

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode lastnot9node = dummy;

        while(diff > 0){
            // create new node
            tail.next = new ListNode(l1.val);

            // update lastnot9node
            if(l1.val != 9) {
                lastnot9node = tail.next;
            }

            // update tails
            tail = tail.next;
            l1 = l1.next;
            diff--;
        }

        while(l1 != null){
            int val = l1.val + l2.val;

            if(val >= 10){
                val -= 10;
                // update previous nodes
                lastnot9node.val++;
                lastnot9node = lastnot9node.next;
                while(lastnot9node != null){
                    lastnot9node.val = 0;
                    lastnot9node = lastnot9node.next;
                }
                lastnot9node = tail;
            }

            // create new node
            tail.next = new ListNode(val);

            // update lastnot9node
            if(val != 9) lastnot9node = tail.next;

            // update tails
            tail = tail.next;
            l1   = l1.next;
            l2   = l2.next;
        }

        if(dummy.val == 1) {
            return dummy;
        }
        return dummy.next;
    }

    private int getLength(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}
