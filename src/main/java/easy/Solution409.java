package easy;

public class Solution409 {
    public int longestPalindrome(String s) {
        int [] mem = new int[256];
        for(char c : s.toCharArray()) {
            mem[c]++;
        }

        int evenCounter = 0;
        int oddCounter = 0;
        for(int i: mem) {
            if ((i % 2) == 0) {
                evenCounter += i;
            }
            else if ((i % 2) > 0) {
                evenCounter += (i - 1);
                oddCounter = 1;
            }
            else
                oddCounter = 1;
        }
        return evenCounter + oddCounter;
    }
}
