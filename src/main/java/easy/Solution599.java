package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null || list1.length == 0 || list2.length == 0) return null;
        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i< list2.length; i++) {
            map.put(list2[i], i);
        }
        int minSum = Integer.MAX_VALUE;

        for(int i = 0 ; i< list1.length; i++) {
            String variant = list1[i];
            if (map.containsKey(variant)) {
                int minCandidate = i + map.get(variant);
                if (minCandidate <= minSum) {
                    minSum = minCandidate;
                    result.add(variant);
                }
            }
        }
        return  result.toArray(new String[result.size()]);
    }
}
