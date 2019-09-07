package easy;

import java.util.ArrayList;
import java.util.List;

public class Solution119 {

    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < rowIndex + 1; i++) {
            res.add(0, 1);
            for(int j = 1; j < res.size() - 1; j++) {
                res.set(j, res.get(j) + res.get(j + 1));
            }
        }
        return res;
    }
}
