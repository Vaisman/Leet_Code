package Amazon;

import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastIndex = new int[256];
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++){
            lastIndex[arr[i]] = i;
        }

        List<Integer> res = new LinkedList<>();
        for (int start = 0, end = 0; start < arr.length; start = end+1){
            end = lastIndex[arr[start]];
            for (int i = start; i < end; i++){
                if (end < lastIndex[arr[i]])
                    end = lastIndex[arr[i]];
            }
            res.add(end - start + 1);
        }

        return res;
    }
}
