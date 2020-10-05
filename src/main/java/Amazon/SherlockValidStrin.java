package Amazon;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SherlockValidStrin {
    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), charMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        int highest = 0;
        int secondHighest = 0;
        int singleCharcount = 0;
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            int num = entry.getValue();
            if (num == 1) {
                singleCharcount++;
                if (singleCharcount >= 2) {
                    return "NO";
                }
            }
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest) {
                secondHighest = num;
            }
        }

        if (highest - secondHighest > 2) {
            return "NO";
        } else {
            return "YES";
        }
    }

    @Test
    public void test() {
        System.out.println(isValid("aabbccddeefghi"));
    }
}