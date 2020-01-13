package medium;

import org.junit.Test;

public class Solution875 {
    public int minEatingSpeed(int[] piles, int H) {
        int i = 1;
        int j = getMax(piles);
        while(i < j){
            int mid = i + (j-i) / 2;
            int total = getTotal(piles, mid);
            if(total <= H){
                j = mid;
            }else{
                i = mid+1;
            }
        }
        return i;

    }

    private int getMax(int[] piles) {
        int max = piles[0];
        for(int i = 1; i < piles.length;i++) {
            max = Math.max(max, piles[i]);
        }
        return max;
    }

    private int getTotal(int[] piles, int k){
        int ret = 0;
        for(int i : piles){
            ret += (i-1)/k+1;
        }
        return ret;
    }

    @Test
    public void test() {
        minEatingSpeed(new int[]{3,6,7,11}, 8);
    }
}
