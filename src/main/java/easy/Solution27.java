package easy;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return -1;

        int l = 0;
        int r = nums.length -1;
        while (l<r) {
            if (nums[l] == val) {
                nums[l--] = nums[r--];
            }
            else {
                l++;
            }
        }
        return l;
    }
}
