package easy;

public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return n == 0;
        }

        for(int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int left = i-1 < 0 ? 0 : flowerbed[i-1];
                int right = i+1 >= flowerbed.length ? 0 : flowerbed[i+1];
                if (left == 0 && right == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
                if (n <= 0) return true;
            }
        }
        return n <= 0;
    }
}

/*
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
*/
