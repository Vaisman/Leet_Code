package medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int index = queue.poll();
            visited.add(index);
            if(arr[index]==0){
                return true;
            }

            if(!visited.contains(index+arr[index])){
                if(index+arr[index] < arr.length){
                    queue.add(index+arr[index]);
                }
            }

            if(!visited.contains(index-arr[index])){
                if(index-arr[index] >=0){
                    queue.add(index-arr[index]);
                }
            }
        }
        return false;
    }
}
