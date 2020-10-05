package Amazon;

import org.junit.Test;

public class KLengthSubString {
    public String solution(String message, int k) {
        // write your code in Java SE 8

        // Input validations
        if (message == null || message.isEmpty()) return message;
        if (k <= 0) return "";

        // cut out spaces from the input
        message = message.trim();

        // split on space for all the words
        String[] words = message.split(" ");

        // For the output
        StringBuilder kLength = new StringBuilder();

        // Temporary variable for the word separator
        String separator = "";
        for (String iWord : words) {
            if (iWord.trim().isEmpty()) continue;
            if (kLength.length() + 1 + iWord.length() <= k) {
                kLength.append(separator).append(iWord);
            } else {
                break;
            }
            separator = " ";
        }

        // .trim here is to avoid spaces being appended
        return kLength.toString().trim();
    }

    @Test
    public void test() {
        String ans = solution("The quick brown fox jumps over the lazy dog", 39);
        System.out.println(ans.length() + " : \"" + ans + "\"");
        ans = solution("codility we test coders", 14);
        System.out.println(ans.length() + " : \"" + ans + "\"");
        ans = solution("c odility we test coders", 1);
        System.out.println(ans.length() + " : \"" + ans + "\"");
        ans = solution("c odility  we  test,           coders.                 ", 100);
        System.out.println(ans.length() + " : \"" + ans + "\"");
        ans = solution("codility we test coders", 0);
        System.out.println(ans.length() + " : \"" + ans + "\"");
        ans = solution("", 100);
        System.out.println(ans.length() + " : \"" + ans + "\"");
        ans = solution("asdf asdf asdf ", 100);
        System.out.println(ans.length() + " : \"" + ans + "\"");
    }
}