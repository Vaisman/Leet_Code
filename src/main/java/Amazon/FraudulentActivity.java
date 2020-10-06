package Amazon;

import org.junit.Test;

import java.util.*;

// FraudLogs
public class FraudulentActivity {
    public List<String> getFraudIds(String[] input, int threshold) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String log : input) {
            String[] logVals = log.split(" ");
            Set<String> set = new HashSet<>(Arrays.asList(logVals[0], logVals[1]));
            for (String userId : set) {
                map.put(userId, map.getOrDefault(userId, 0) + 1);
            }
        }

        for (String userId : map.keySet()) {
            if (map.get(userId) >= threshold)
                res.add(userId);
        }

        Collections.sort(res);
        return res;
    }

    @Test
    public void test() {
        String[] input = new String[] {
                "345366 89921 45",
                "029323 38239 23",
                "38239 345366 15",
                "029323 38239 77",
                "345366 38239 23",
                "029323 345366 13",
                "38239 38239 23" };
        System.out.println(getFraudIds(input, 3));
    }
}
