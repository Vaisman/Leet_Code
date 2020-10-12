package Amazon;

import org.junit.Test;

import java.util.*;

public class JobsDuration {
    private static void solve(String[] strs) {
        List<String> resDFS = new ArrayList<>();
        List<String> resBFS = new ArrayList<>();
        Map<Character, Map<Character, Integer>> map = new HashMap<>();
        Map<Character, Integer> roots = new HashMap<>();
        for(String s : strs) {
            String[] sArr = s.split(" ");
            if(sArr[1].equals("null"))
                roots.put(sArr[0].charAt(0), Integer.parseInt(sArr[2]));
            else {
                map.putIfAbsent(sArr[1].charAt(0), new HashMap<>());
                map.get(sArr[1].charAt(0)).put(sArr[0].charAt(0), Integer.parseInt(sArr[2]));
            }
        }
        for(Map.Entry<Character, Integer> root : roots.entrySet()) {
            resDFS.add(root.getKey() + " "  + (root.getValue() + dfs(map, root)));
        }
        for(Map.Entry<Character, Integer> root : roots.entrySet()) {
            resBFS.add(root.getKey() + " "  + bfs(map, root));
        }
        System.out.println(resDFS);
        System.out.println(resBFS);
    }

    private static Integer bfs(Map<Character, Map<Character, Integer>> map, Map.Entry<Character, Integer> root) {
        int res = 0;
        Queue<Map.Entry<Character, Integer>> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Map.Entry<Character, Integer> e = q.poll();
            char cur = e.getKey();
            res += e.getValue();
            if(!map.containsKey(cur))
                continue;
            for(Map.Entry<Character, Integer> nei : map.get(cur).entrySet()) {
                q.offer(nei);
            }
        }
        return res;
    }

    private static int dfs(Map<Character, Map<Character, Integer>> map, Map.Entry<Character, Integer> root) {
        if(!map.containsKey(root.getKey()))
            return 0;
        int res = 0;
        for(Map.Entry<Character, Integer> e : map.get(root.getKey()).entrySet()) {
            res += (e.getValue() + dfs(map, e));
        }
        return res;
    }

    // -----------------------------------------------------

    static ArrayList<String> res = new ArrayList<>();
    static int t=0;
    private List<String> solve1(String[] strs) {
        Map<String, List<String[]>> map = new HashMap<>();

        int[] process = new int[26];
        int[] visited = new int[26];

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            String st[] = s.split(" ");
            if (st[1].equals("null"))
                process[(int) st[0].charAt(0) - 'A'] = Integer.parseInt(st[2]);
            else {
                map.computeIfAbsent(st[1], k -> new ArrayList<>()).add(new String[]{st[0], st[2]});
                map.computeIfAbsent(st[0], k -> new ArrayList<>()).add(new String[]{st[1], st[2]});
            }
        }
        for (int i = 0; i < 26; i++) {
            t = 0;
            if (process[i] != 0 && visited[i] == 0) {
                String str = Character.toString((char) (i + 'A'));
                dfs(str, process[i], visited, map);
                res.add(str + " " + t);
            }
        }
        return res;
    }

    static void dfs(String process , int cost , int []visited, Map<String, List<String []>> map) {
        if (visited[(int) process.charAt(0) - 'A'] == 0 && map.containsKey(process)) {
            visited[(int) process.charAt(0) - 'A'] = 1;
            t += cost;
            List<String[]> childProcess = map.get(process);
            for (String[] pr : childProcess) {
                dfs(pr[0], Integer.parseInt(pr[1]), visited, map);
            }
        }
    }

    @Test
    public void test() {
        String[] strs = {
                "E B 400",
                "G null 10",
                "B A 100",
                "F B 600",
                "D A 20",
                "A null 20",
                "C A 250",
                "H G 20"};
        solve(strs);
        solve1(strs);
        for(int i=0;i<res.size();i++)
           System.out.println(res.get(i));
    }
}
