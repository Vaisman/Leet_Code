package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution412 {
    public List<String> fizzBuzz(int n) {
        if (n <= 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            if (i >= 3 ) {
                if (((i % 3) == 0) &&  ((i % 5) == 0)){
                    result.add("FizzBuzz");
                    continue;
                }
                if ((i % 3) == 0) {
                    result.add("Fizz");
                    continue;
                }
                if ((i % 5) == 0) {
                    result.add("Buzz");
                    continue;
                }
            }
            result.add(Integer.toString(i));
        }

        return result;
    }
}
