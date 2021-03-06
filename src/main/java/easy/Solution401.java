package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution401 {
    public List<String> readBinaryWatch(int num) {
        if (num < 0) {
            return new ArrayList<>();
        }

        List<String> times = new ArrayList<>();
        for (int h=0; h<12; h++)
            for (int m=0; m<60; m++)
                if (Integer.bitCount(h) + Integer.bitCount(m) == num)
                    times.add(String.format("%d:%02d", h, m));
        return times;
    }
}
