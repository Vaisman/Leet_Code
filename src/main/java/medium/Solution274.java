package medium;

import org.junit.Test;

public class Solution274 {
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }

        int left = 0;
        int right = citations.length;
        while (left <= right) {
            int mid = (left + right)/2;
            int count = count(citations, mid);
            if (count == mid) {
                return mid;
            } else if (count > mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private int count(int[] array, int target) {
        int count = 0;
        for (int i1 : array) {
            if (i1 >= target) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test(){
        hIndex(new int[]{3,0,6,1,5});
    }
}
