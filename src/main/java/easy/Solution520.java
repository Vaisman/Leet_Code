package easy;

public class Solution520 {
    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() == 0)
            return false;

        boolean first = true;
        boolean second = true;
        boolean third = true;

        if (!Character.isUpperCase(word.charAt(0))) {
            first = false;
            third = false;
        }

        for(int i = 1; i < word.length(); i++){
            boolean upper = Character.isUpperCase(word.charAt(i));

            if (upper) {
                second = false;
                third = false;
            }
            else{
                first = false;
            }
        }
        return first || second || third;
    }
}
