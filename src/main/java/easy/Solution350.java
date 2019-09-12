package easy;

import java.util.Arrays;

public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len = nums1.length >= nums2.length ? nums1.length : nums2.length;
        int[] result = new int[len];

        int i=0;
        int j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count=0;

        while (i<nums1.length && j<nums2.length) {
            if (nums1[i]<nums2[j]) {
                i++;
            }
            else if(nums1[i]>nums2[j]) {
                j++;
            }
            else{
                result[count] = nums1[i];
                i++;
                j++;
                count++;
            }
        }

        int[] out = Arrays.copyOfRange(result,0,count);
        return out;
    }
}
