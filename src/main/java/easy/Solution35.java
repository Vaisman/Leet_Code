package easy;

public class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int pos = -1;
        if (nums == null || nums.length == 0) {
            return pos;
        }

        if ((target > nums[nums.length-1]) || (target < nums[0])) {
            return pos;
        }

        int l = 0;
        int r = nums.length-1;
        while(l<=r) {
            int currPos = (l+r) / 2;
            if (nums[currPos] == target) {
                return currPos;
            } else if (nums[currPos] < target) {
                l = currPos+1;
            } else {
                r = currPos-1;
            }
        }
        return l;
    }
}

//Input: [1,3,5,6], 5
//Output: 2
