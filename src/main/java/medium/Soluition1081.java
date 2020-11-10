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
}
