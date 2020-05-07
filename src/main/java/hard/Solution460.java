package hard;

import java.util.HashMap;

class Solution460 {
    class Node {
        int key, val;
        int freq;
        Node prev, next;

        public Node(int k, int v) {
            key = k;
            val = v;
            freq = 0;
            prev = next = this;
        }

        public void remove() {
            prev.next = next;
            next.prev = prev;
        }

        public void addBefore(Node head) {
            prev = head.prev;
            prev.next = this;
            next = head;
            head.prev = this;
        }
    }

    private HashMap<Integer, Node> nodeMap = new HashMap<>();
    private HashMap<Integer, Node> freqMap = new HashMap<>();
    private int minFreq, cap;

    public Solution460(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        Node cur = nodeMap.get(key);
        if (cur == null) return -1;

        removeNode(cur);
        addNode(cur);

        return cur.val;
    }

    public void put(int key, int value) {
        if (cap == 0) return;

        Node cur = nodeMap.get(key);

        if (cur != null) {
            cur.val = value;
            removeNode(cur);
        } else {
            if (nodeMap.size() == cap) {
                Node head = freqMap.get(minFreq);
                nodeMap.remove(head.next.key);
                removeNode(head.next);
            }

            cur = new Node(key, value);
            minFreq = 1;
            nodeMap.put(key, cur);
        }
        addNode(cur);
    }

    private void removeNode(Node cur) {
        Node nextNode = cur.next;

        cur.remove();
        if (nextNode.next == nextNode) {
            freqMap.remove(cur.freq);
            if (minFreq == cur.freq)
                minFreq++;
        }
    }

    private void addNode(Node cur) {
        cur.freq++;

        Node head = freqMap.get(cur.freq);
        if (head == null) {
            head = new Node(0, 0);
            freqMap.put(cur.freq, head);
        }
        cur.addBefore(head);
    }
}