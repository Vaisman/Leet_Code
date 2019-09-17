package easy;

public class Solution504 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int sign = num >= 0 ? 1 : -1;

        while(num !=0) {
            sb.append(Math.abs(num % 7));
            num /= 7;
        }
        sb.append(sign < 0 ? "-" : "");
        return sb.reverse().toString();
    }
}
