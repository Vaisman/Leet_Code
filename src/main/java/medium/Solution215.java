package medium;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        return findKth(nums, nums.length - k, 0, nums.length - 1);
    }

    private int findKth(int[] nums, int k, int start, int end) {
        if (start >= end) {
            return nums[k];
        }

        int l = start, r = end;
        int pivot = nums[(l + r) / 2];
        while (l <= r) {
            while (l <= r && nums[l] < pivot) {
                l++;
            }
            while (l <= r && nums[r] > pivot) {
                r--;
            }
            if (l <= r) {
                int tmp = nums[l];
                nums[l] = nums[r];
                nums[r] = tmp;
                l++; r--;
            }
        }

        if (k <= r) {
            return findKth(nums, k, start, r);
        }
        if (k >= l) {
            return findKth(nums, k, l, end);
        }
        return nums[k];
    }
}
