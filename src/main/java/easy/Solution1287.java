package easy;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Solution1287 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if(n==1) {
            return arr[0];
        }
        List<Integer> list = new ArrayList<>(Arrays.asList(arr[n/4],arr[n/2],arr[(3*n)/4]));

        for (int element : list) {
            int f = firstOccurrence(arr,element);
            int l = lastOccurrence(arr,element);
            if(l-f+1>n/4) {
                return element;
            }
        }
        return -1;
    }

    private int firstOccurrence(int[] nums, int target) {
        int start=0;
        int end = nums.length-1;
        while(start < end){
            int middle = start + (end - start)/2;
            if(nums[middle]==target && (middle==start || nums[middle-1]<target)) {
                return middle;
            }
            if(target > nums[middle])
                start = middle + 1;
            else
                end = middle;
        }
        return start;

    }

    private int lastOccurrence(int[] nums,int target) {
        int start=0;
        int end = nums.length-1;
        while(start < end){
            int middle = start + (end - start)/2;
            if(nums[middle]==target && (middle==end || nums[middle+1]>target)) {
                return middle;
            }
            if(nums[middle] > target)
                end = middle;
            else
                start = middle + 1;
        }
        return start;
    }

    @Test
    public void test() {
        find_doubles_in_list(Arrays.asList(1,2,3,4,5,6,7,8,9,0,8));
        int aa = 1;
    }

    public static void find_doubles_in_list(List<Integer> values) {
        Collections.sort(values);
        Map<Integer, Integer> numb = new HashMap<>();
        for(Integer value : values) {
            numb.put(value, numb.getOrDefault(value, 0) +1);
        }

        for(Integer value : values) {
            if (numb.get(value) == 1) {
                if (value == 1) {
                    if (numb.containsKey(2)) {
                        System.out.println(value);
                    }
                }
                else if (numb.containsKey(value*value)) {
                    System.out.println(value);
                }
            }
        }
    }

    public static void print_classification(List<List<Integer>> raw_data) {
        Map<Integer, Integer> score = new HashMap<>();
        score.put(1, 10);
        score.put(2, 6);
        score.put(3, 4);
        score.put(4, 3);
        score.put(5, 2);
        score.put(6, 1);

        Map<Integer, Integer> nums = new HashMap<>();
        for(List<Integer> row : raw_data) {
            int sc = row.get(2);
            nums.put(row.get(1), nums.getOrDefault(row.get(1), 0) + ((sc > 6) ? 1 : score.get(sc)));
        }
        int maxval = Integer.MIN_VALUE;
        int maxgamer = Integer.MIN_VALUE;

        for(Map.Entry<Integer, Integer> e :nums.entrySet()) {
            if (e.getValue() > maxval) {
                maxval = e.getValue();
                maxgamer = e.getKey();
            }
        }
        System.out.print(maxgamer + " " + maxval);
    }

}
