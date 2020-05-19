package hard;

import org.junit.Test;

import java.util.TreeSet;

public class Solution480 {
    TreeSet<Integer> lower;
    TreeSet<Integer>upper;

    public double[] medianSlidingWindow(int[] nums, int k) {
        //lower -->max Heap
        // upper -->minHeap
        lower = new TreeSet<>(
                (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[b], nums[a]) : a - b);
        //--->maxHeap
        upper = new TreeSet<>(
                (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b);
        //===>minheap


        double[] res = new double[nums.length + 1 - k];
        int index = 0;
        //firstWindow
        for (int i = 0; i < k; i++) {
            addNum(i, lower, upper);
        }
        balanceHeap(lower, upper);
        int r = 0;
        for (int i = k; i < nums.length; i++) {
            res[index] = getMedian(lower, upper, k, nums);
            index++;
            removeNum(r, lower, upper);
            r++;
            addNum(i, lower, upper);
            balanceHeap(lower, upper);
        }
        //last window median
        res[index] = getMedian(lower, upper, k, nums);
        return res;
    }

    public void addNum(int x,TreeSet<Integer>lower,TreeSet<Integer>upper) {
        upper.add(x);
        lower.add(upper.pollFirst());
    }

    public void removeNum(int removeIndex,TreeSet<Integer>lower,TreeSet<Integer>upper) {
        if(lower.contains(removeIndex))
            lower.remove(removeIndex);
        else upper.remove(removeIndex);
    }

    public void balanceHeap(TreeSet<Integer>lower,TreeSet<Integer>upper) {
        while(lower.size()>upper.size())
            upper.add(lower.pollFirst());
    }

    public double getMedian(TreeSet<Integer>lower,TreeSet<Integer>upper,int k,int [] nums) {
        if(k%2==0)return ((double)nums[lower.first()]+nums[upper.first()])/2;
        else return (double) nums[upper.first()];
    }

    @Test
    public void test() {
        medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
    }
}
