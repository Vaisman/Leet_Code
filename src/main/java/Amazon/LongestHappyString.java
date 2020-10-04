package Amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', a);
        map.put('b', b);
        map.put('c', c);

        Queue<Character> pq = new PriorityQueue<>(8, (p, q) -> map.get(q) - map.get(p));
        if (a > 0) pq.offer('a');
        if (b > 0) pq.offer('b');
        if (c > 0) pq.offer('c');

        StringBuilder ret = new StringBuilder();
        while (!pq.isEmpty()) {
            char x1 = pq.poll();
            int cnt1 = map.get(x1);
            if (pq.isEmpty()) {
                for (int i = 0; i < Math.min(cnt1, 2); i += 1) {
                    ret.append(x1);
                }
                return ret.toString();
            }
            char x2 = pq.poll();
            int cnt2 = map.get(x2);
            int num = Math.min(2, cnt1 - cnt2 + 1);
            for (int i = 0; i < num; i += 1) {
                ret.append(x1);
            }
            ret.append(x2);
            map.put(x1, cnt1 - num);
            map.put(x2, cnt2 - 1);
            if (map.get(x1) > 0) pq.offer(x1);
            if (map.get(x2) > 0) pq.offer(x2);
        }
        return ret.toString();
    }
}
