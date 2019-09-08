package easy;

public class Solution168 {
    public String convertToTitle(int n) {
        if (n <= 0) return "";

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append((char) ('A' + (n - 1) % 26));
            n = n / 26;
        }
        return sb.reverse().toString();
    }
}
