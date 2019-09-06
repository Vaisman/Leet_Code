package easy;

public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = n + m - 1;

        while (i>=0 && j>=0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums2[j];
                j--;
            }
            else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }

        while (j>=0)
            nums1[k--]=nums2[j--];
    }
}

/*
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/
