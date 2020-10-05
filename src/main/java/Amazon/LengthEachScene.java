package Amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class LengthEachScene {

    List<Integer> lengthEachScene(List<Character> inputList) {
        // WRITE YOUR CODE HERE
        int[] last = new int[26];
        for (int i = 0; i < inputList.size(); ++i) {
            last[inputList.get(i) - 'a'] = i;
        }

        int j = 0, anchor = 0;
        List<Integer> result = new ArrayList();
        for (int i = 0; i < inputList.size(); ++i) {
            j = Math.max(j, last[inputList.get(i) - 'a']);
            if (i == j) {
                result.add(i - anchor + 1);
                anchor = i + 1;
            }
        }

        return result;

    }

    @Test
    public void test() {
        List<Character> inputList1 = asList('a', 'b', 'c');
        List<Character> inputList2 = asList('a', 'b', 'c', 'a');

        LengthEachScene les = new LengthEachScene();
        List<Integer> result1 = les.lengthEachScene(inputList1);
        System.out.println(result1.toString());
        List<Integer> result2 = les.lengthEachScene(inputList2);
        System.out.println(result2.toString());
    }
}
