package Amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://en.wikipedia.org/wiki/Tarjan%27s_strongly_connected_components_algorithm

public class CriticalRouters {

    int edgeIndex = 0;
    int[] to;
    int[] next;
    int[] head;
    int[] low;
    int[] disc;
    int time = -1;

    List<List<Integer>> res = new ArrayList<>();
    private void addEdge(int u, int v) {
        to[edgeIndex] = v;
        next[edgeIndex] = head[u];
        head[u] = edgeIndex ++;
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        low = new int[n];
        disc = new int[n];
        int m = connections.size();
        to = new int[m * 2];
        head = new int[n];
        next = new int[m * 2];
        Arrays.fill(head, -1);
        Arrays.fill(next, -1);
        Arrays.fill(low, -1);
        Arrays.fill(disc, -1);

        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);
            addEdge(u, v);
            addEdge(v, u);
        }

        dfs(1, -1);
        return res;
    }
    private void dfs(int node, int parent) {
        if (disc[node] != -1) {
            return;
        }
        low[node] = disc[node] = ++ time;
        for (int edge = head[node]; edge != -1; edge = next[edge]) {
            int next = to[edge];
            if (disc[next] == -1) {
                dfs(next, node);
                low[node] = Math.min(low[node], low[next]);
                if (low[next] > disc[node]) {
                    res.add(Arrays.asList(node, next));
                }
            } else if (next != parent) {
                low[node] = Math.min(low[node], disc[next]);
            }
        }
    }

    //------------------------------
    // check every node by DSU
    public List<Integer> getCriticalNodes(int[][] edges, int numNodes, int numEdges){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numEdges; i++){
            if(!checkConnection(edges, i, numNodes)){
                res.add(i);
            }
        }
        return res;
    }

    public boolean checkConnection(int[][] edges, int removeNode, int numNodes){
        int[] root = new int[numNodes];

        for(int i = 0; i < numNodes; i++){
            root[i] = i;
        }

        for(int[] edge: edges){
            if(edge[0] == removeNode || edge[1] == removeNode){
                continue;
            }
            int root1 = getRoot(root, edge[0]);
            int root2 = getRoot(root, edge[1]);
            if( root1 != root2){
                root[root1] = root[root2];
            }
        }
        int rootCount = 0;
        for(int i = 0; i < root.length; i++){
            if(root[i] == i && i != removeNode){
                rootCount++;
            }
        }

        return rootCount == 1;
    }

    public int getRoot(int[] root, int index){
        while(root[index] != index){
            index = root[index];
        }
        return index;
    }

    @Test
    public void test() {
        List<List<Integer>> connections = Arrays.asList(
                Arrays.asList(0,1),
                Arrays.asList(0,2),
                Arrays.asList(1,3),
                Arrays.asList(2,3),
                Arrays.asList(2,5),
                Arrays.asList(5,6),
                Arrays.asList(3,4)
        );

        List<Integer> res = getCriticalNodes(new int[][] {{0,1},{0,2},{1,3},{2,3},{2,5},{5,6},{3,4}}, 7,7);
    }
}
