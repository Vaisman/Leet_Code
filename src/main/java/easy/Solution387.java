package easy;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class Solution387 {
    public int firstUniqChar(String s) {
        Map<Character, Node> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i ++) {
            if (!freq.containsKey(s.charAt(i))) {
                freq.put(s.charAt(i), new Node(i, 1));
            }
            else {
                freq.get(s.charAt(i)).freq++;
            }
        }

        int pos = -1;
        for(char c: freq.keySet()) {
            if (freq.get(c).freq == 1) {
                pos = pos == -1 ? freq.get(c).pos : Math.min(pos, freq.get(c).pos);
            }
        }
        return pos;
    }

    class Node {
        public Node(int pos, int freq) {
            this.pos = pos;
            this.freq = freq;
        }

        int pos;
        int freq;
    }

    @Test
    public void test() {
       firstUniqChar("leetcode");
    }
}

/*
s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
*/