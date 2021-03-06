package easy;

import java.util.TreeMap;

public class Solution1128 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0) {
            return new int[]{};
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int i = 0;
        for(int n : arr2) {
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }

        for(int n : map.keySet()){
            while(map.get(n) > 0) {
                arr1[i++] = n;
                map.put(n, map.get(n)-1);
            }
        }
        return arr1;
    }

    // 1000 constraint
    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int st[]=new int[1001];

        for(int x:arr1){
            st[x]++;
        }

        int j=0;
        for(int p:arr2){
            for(int i=0;i<st[p];i++)
                arr1[j++]=p;
            st[p]=0;
        }
        for(int k=1;k<=1000;k++){
            for(int i=0;i<st[k];i++)
                arr1[j++]=k;
        }
        return arr1;
    }
}
