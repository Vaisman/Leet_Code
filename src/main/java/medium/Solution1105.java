package medium;

import java.util.HashMap;
import java.util.Map;

public class Solution1105 {
    Map<Integer, Integer> map = new HashMap<>();
    public int minHeightShelves(int[][] books, int shelf_width) {
        return shelf(books, 0, shelf_width);
    }

    int shelf(int[][] books, int index, int width) {
        if (index>=books.length)
            return 0;
        if (map.containsKey(index))
            return map.get(index);

        int w = 0;
        int max= 0;
        int res = Integer.MAX_VALUE;
        for (int i=index; i<books.length; i++) {
            w += books[i][0];
            if (w>width)
                break;

            max = Math.max(max, books[i][1]);
            res = Math.min(res, max+shelf(books, i+1, width));
        }

        map.put(index, res);
        return res;
    }
}
