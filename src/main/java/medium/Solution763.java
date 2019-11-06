package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty())
            return result;

        int[] lastPosition = new int[256];
        for(int i = 0;i< s.length();i++){
            lastPosition[s.charAt(i)] = i;
        }

        int counter = 0;
        int j = 0;
        for (int i = 0; i < s.length(); ++i) {
            counter++;
            j = Math.max(j, lastPosition[s.charAt(i)]);
            if (i == j) {
                result.add(counter);
                counter = 0;
            }
        }

        return result;
    }
}
