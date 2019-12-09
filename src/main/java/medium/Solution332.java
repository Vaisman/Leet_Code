package medium;

import java.util.*;

public class Solution332 {
    Map<String, PriorityQueue<String>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if(tickets == null || tickets.size() == 0) return res;

        map = new HashMap<>();
        for(List<String> ticket: tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        if(!map.containsKey("JFK")) return res;
        dfs("JFK", res);
        return res;
    }

    private void dfs(String start, List<String> res) {
        PriorityQueue<String> pq = map.get(start);
        while(pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), res);
        }
        res.add(0, start);
    }
}
