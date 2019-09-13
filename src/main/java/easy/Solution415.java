package easy;

public class Solution415 {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0)
            return num1;
        if (num2 == null || num2.length() == 0)
            return num2;

        StringBuilder sb = new StringBuilder();

        int curr = 0;
        for(int i = num1.length()-1, j = num2.length()-1; i >= 0 || j>=0; i--, j--) {
            int value1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int value2 = j >= 0 ? num2.charAt(j) - '0' : 0;

            sb.append( (value1 + value2 + curr) % 10 );
            curr = (value1 + value2 + curr) / 10;
        }
        if (curr >0)
            sb.append(curr);
        return sb.reverse().toString();
    }
}
