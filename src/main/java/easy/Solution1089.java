package easy;

import org.junit.Test;

public class Solution1089 {
    public void duplicateZeros(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) countZero++;
        }

        int len = arr.length + countZero;
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i];
            } else {
                if (j < arr.length) arr[j] = arr[i];
                j--;
                if (j < arr.length) arr[j] = arr[i]; //copy twice when hit '0'
            }
        }
    }

    @Test
    public void test() {
        int[] list = new int[]{1,0,2,3,0,4,5,0};
        duplicateZeros(list);
    }
}