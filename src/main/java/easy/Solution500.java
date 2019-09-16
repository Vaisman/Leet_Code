package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution500 {
    private Set<Character> pocket1 = new HashSet<>(Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'));
    private Set<Character> pocket2 = new HashSet<>(Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'));
    private Set<Character> pocket3 = new HashSet<>(Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm'));

    private boolean contains(String s){
        boolean first = true;
        boolean second = true;
        boolean third = true;

        for(int i = 0;i< s.length(); i++) {
            Character ch = Character.toLowerCase(s.charAt(i));

            if (!pocket1.contains(ch))
                first = false;

            if (!pocket2.contains(ch))
                second = false;

            if (!pocket3.contains(ch))
                third = false;
        }
        return first || second || third;
    }

    public String[] findWords(String[] words) {
        if (words == null)
            return null;

        List<String> result = new LinkedList<>();

        for(String s : words){
            if (contains(s)){
                result.add(s);
            }
        }

        return result.toArray(new String[0]);
    }
}
