package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution1104 {
    public List<Integer> pathInZigZagTree(int label) {
        int level = 0;
        while (1 << level <= label) {
            ++level;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < level; i++) {
            res.add(0);
        }

        for(; label >= 1; label /= 2, --level) {
            res.set(level - 1, label);
            label = (1 << level) - 1 - label + (1 << (level - 1));
        }
        return res;
    }

    @Test
    public void test() {
        pathInZigZagTree(14);
    }
}
