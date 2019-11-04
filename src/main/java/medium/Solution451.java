package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution451 {
    public String frequencySort(String s) {
        if (s == null || s.isEmpty()) return s;

        int[] freq = new int[255];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        List<List<Character>> f = new ArrayList<>();
        for(int i = 0; i < s.length() + 1; i++) {
            f.add(new ArrayList<>());
        }

        for (int character = 0; character < freq.length; character++) {
            int chFreq = freq[character];
            if (chFreq > 0) {
                List<Character> cc = f.get(chFreq);
                cc.add((char)character);
            }
        }

        StringBuilder res = new StringBuilder();
        for(int i = f.size()-1; i >= 0; i--) {
            List<Character> l = f.get(i);
            for(char c : l ) {
                for(int j=0; j < freq[c]; j++)
                    res.append(c);
            }
        }
        return res.toString();
    }
}
