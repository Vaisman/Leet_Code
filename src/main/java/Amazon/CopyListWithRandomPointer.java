package Amazon;

import java.util.HashMap;

public class CopyListWithRandomPointer {
   class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return head;

        RandomListNode temp = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        while (temp != null) {
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            RandomListNode curr = map.get(temp);
            curr.random = map.get(temp.random);
            curr = map.get(temp);
            curr.next = map.get(temp.next);
            temp = temp.next;
        }

        return map.get(head);
    }
}
