package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution310 {

    // Time Complexity - O(V+E), Space Complexity - O(V)
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) {
            return Arrays.asList(0);
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++) {
            graph.put(i, new HashSet<>());
        }

        //build graph
        for(int[] edge : edges){
            //In a bi-directional way
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(graph.get(i).size()==1)
                leaves.add(i);
        }

        while(n>2) {
            List<Integer> newLeaves = new ArrayList<>();
            n-=leaves.size(); // this is just to break
            for(int leaf : leaves){
                int parent = graph.get(leaf).iterator().next();
                graph.get(parent).remove(leaf);
                if(graph.get(parent).size()==1)
                    newLeaves.add(parent);
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
