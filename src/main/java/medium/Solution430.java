package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    };

    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }

        Node dummy = new Node(0, null, head, null);

        flattenDFS(dummy, head);

        dummy.next.prev = null;
        return dummy.next;
    }

    private Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;

        curr.prev = prev;
        prev.next = curr;

        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }

    public Node flatten1(Node head) {
        if (head == null) return head;

        Node dummy = new Node(0, null, head, null);
        Node curr, prev = dummy;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                curr.child = null;
            }
            prev = curr;
        }
        dummy.next.prev = null;
        return dummy.next;
    }
}
