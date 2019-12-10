package easy;

import org.junit.Test;

import java.util.Arrays;

public class Solution758 {
    public String boldWords(String[] words, String s) {
        boolean[] bold = new boolean[s.length()];
        for(String w: words){
            int start = s.indexOf(w, 0);
            while(start != -1){
                Arrays.fill(bold, start, start + w.length(), true);
                start = s.indexOf(w, start + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean open = false;

        for(int i = 0; i< bold.length; i++){
            if(bold[i] && !open) {
                sb.append("<b>");
                open = true;
            } else if(!bold[i] && open){
                sb.append("</b>");
                open = false;
            }
            sb.append(s.charAt(i));
        }
        if(open) sb.append("</b>");
        return sb.toString();
    }

    @Test
    public void test() {
        String[] words = {"ab", "bc"};
        String S = "aabcd";

        boldWords(words, S);
    }
}
