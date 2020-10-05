package Amazon;

import org.junit.Test;

import java.util.*;

public class CriticalConnections {
    // check every node by DSU like in CriticalRouters

    class PairInt {
        int first;
        int second;
        PairInt(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    List<PairInt> list;
    Map<Integer, Boolean> visited;
    List<PairInt> criticalConnections(int numOfServers, int numOfConnections,  List<PairInt> connections) {
        Map<Integer, HashSet<Integer>> adj = new HashMap<>();
        for(PairInt connection : connections){
            int u = connection.first;
            int v = connection.second;
            adj.computeIfAbsent(u, k -> new HashSet<>());
            adj.get(u).add(v);
            adj.computeIfAbsent(v, k -> new HashSet<>());
            adj.get(v).add(u);
        }

        list = new ArrayList<>();
        for(int i =0;i<numOfConnections;i++){
            visited = new HashMap<>();
            PairInt p = connections.get(i);
            int x = p.first;
            int y = p.second;
            adj.get(x).remove(y);
            adj.get(y).remove(x);
            DFS(adj,1);
            if(visited.size()!=numOfServers){
                if(p.first > p.second)
                    list.add(new PairInt(p.second,p.first));
                else
                    list.add(p);
            }
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
        return list;
    }

    public void DFS(Map<Integer, HashSet<Integer>> adj, int u) {
        visited.put(u, true);
        if (!adj.get(u).isEmpty()) {
            for (int v : adj.get(u)) {
                if (!visited.getOrDefault(v, false)) {
                    DFS(adj, v);
                }
            }
        }
    }

    @Test
    public void test() {
        List<PairInt> connections = Arrays.asList(new PairInt(1,2),new PairInt(1,3),new PairInt(2,3),new PairInt(3,4),
                new PairInt(3,6),new PairInt(4,5),new PairInt(6,7),new PairInt(6,9),new PairInt(7,8),new PairInt(8,9));
        List<PairInt> res = criticalConnections(9, 10,connections);
    }
}
