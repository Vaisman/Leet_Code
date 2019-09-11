package easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) return nums1;
        if (nums2 == null || nums2.length == 0) return nums2;

        Set<Integer> set = new HashSet<>();
        for(int i: nums1) {
            set.add(i);
        }

        List<Integer> result = new ArrayList<>();
        for(int i : nums2) {
            if (set.contains(i)) {
                result.add(i);
                set.remove(i);
            }
        }

        int[] arr = new int[result.size()];
        for (int i= 0; i < result.size(); i++)
            arr[i] = result.get(i);
        return arr;
    }
}

/*
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
*/