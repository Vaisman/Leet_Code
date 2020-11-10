package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Soluition1081 {

    public String smallestSubsequence(String s) {
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character,Integer> map = new HashMap<>();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!seen.contains(c)){
                while(!st.isEmpty() && c < st.peek() && map.get(st.peek()) > i){
                    seen.remove(st.pop());
                }
                seen.add(c);
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c:st){
            sb.append(c.charValue());
        }

        return sb.toString();
    }

    public String removeDuplicateLetters(String s) {
        // find pos - the index of the leftmost letter in our solution
        // we create a counter and end the iteration once the suffix doesn't have each unique character
        // pos will be the index of the smallest character we encounter before the iteration ends
        int[] cnt = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos))
                pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0)
                break;
        }
        // our answer is the leftmost letter plus the recursive call on the remainder of the string
        // note that we have to get rid of further occurrences of s[pos] to ensure that there are no duplicates
        return s.length() == 0 ? "" : s.charAt(pos) +
                removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
}
