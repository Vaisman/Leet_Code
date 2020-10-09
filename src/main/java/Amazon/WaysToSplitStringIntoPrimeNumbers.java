package Amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://www.geeksforgeeks.org/split-the-given-string-into-primes-digit-dp/
*/

public class WaysToSplitStringIntoPrimeNumbers {

    private int solve(int n) {
        int mod = (int)1e9 + 7;
        boolean[] arr = new boolean[(int)1e6 + 1];
        Arrays.fill(arr, true);

        for(int i=2;i*i<=(int)1e6;i++) {
            if(arr[i]) {
                for(int j=i;j*i<=(int)1e6;j++) {
                    arr[i*j] = false;
                }
            }
        }

        arr[1] = false;
        arr[0] = false;
        String s = String.valueOf(n);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        for(int i=1;i<=s.length();i++) {
            for(int j=Math.max(0, i-6);j<i;j++) {
                if(arr[Integer.parseInt(s.substring(j, i))]) {
                    dp[i] = (dp[i] + dp[j]) % mod;
                }
            }
        }

        return dp[s.length()];
    }

    //-
    private List<List<Integer>> output = new ArrayList<>();

    private void splitIntoPrimeNumbers(String input, List<Integer> list) {
        if(input.length()==0) {
            output.add(list);
        }
        for(int i=1; i<=input.length(); i++) {
            String subInput = input.substring(0,i);
            int ip = Integer.parseInt(subInput);
            if(isPrime(ip)) {
                List<Integer> list1 = getDeepCopy(list);
                list1.add(ip);
                splitIntoPrimeNumbers(input.substring(i), list1);
            }
        }
    }

    private boolean isPrime(int input) {
        if(input == 1 || input == 0) return false;
        boolean result = true;
        for(int i = 2; i<=input/2; i++) {
            if(input % i == 0) {
                result  = false;
            }
        }
        return result;
    }

    private List<Integer> getDeepCopy(List<Integer> list){
        List<Integer> copyList = new ArrayList<>();
        for(int i : list) {
            copyList.add(i);
        }
        return copyList;
    }

    @Test
    public void test() {
        int n = 11373;
        System.out.println(solve(n));
        splitIntoPrimeNumbers("11373", new ArrayList<Integer>());
    }
}
