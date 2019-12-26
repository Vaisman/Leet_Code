package medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution1135 {
    public int minimumCost(int n, int[][] connections) {
        if (n == 1) {
            return 0;
        }

        List<List<int[]>> graph = getGraph(n, connections);
        boolean[] visited = new boolean[n + 1];

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int cost = 0, numberOfCitiesVisited = 0;

        queue.offer(new int[] {1, 0});
        while (!queue.isEmpty()) {
            int[] u = queue.poll();
            if (visited[u[0]]) {
                continue;
            }
            visited[u[0]] = true;
            cost += u[1]; //first time visit so cumulate the cost
            numberOfCitiesVisited++;

            for (int[] v : graph.get(u[0])) {
                if (!visited[v[0]]) {
                    queue.offer(new int[] {v[0], v[1]});
                }
            }
        }

        return numberOfCitiesVisited == n ? cost : -1;
    }

    private List<List<int[]>> getGraph(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] conn : connections) {
            int c1 = conn[0];
            int c2 = conn[1];
            int price = conn[2];
            graph.get(c1).add(new int[] {c2, price});
            graph.get(c2).add(new int[] {c1, price});
        }
        return graph;
    }
}
