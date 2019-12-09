package medium;

import java.util.*;

public class Solution609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();

        ArrayList<List<String>> res = new ArrayList<>();
        for (String s : paths) {
            String[] files = s.split(" ");
            for (int i = 1; i < files.length; i++) {
                String file = files[i].substring(0, files[i].indexOf('('));
                String content = files[i].substring(files[i].indexOf('(') + 1, files[i].indexOf(')'));
                map.computeIfAbsent(content, k -> new ArrayList<>()).add(files[0] + "/" + file);
            }
        }

        for (List<String> v : map.values()) {
            if (v.size() > 1) {
                res.add(v);
            }
        }
        return res;
    }
}
