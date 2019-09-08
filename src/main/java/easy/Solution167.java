package easy;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] sum = new int[2];
        if (numbers == null || numbers.length == 0) {
            return sum;
        }

        int l = 0;
        int r = numbers.length-1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                sum[0] = l+1;
                sum[1] = r+1;
                return sum;
            } else if (numbers[l] + numbers[r] > target) {
                r--;
            } else {
                l++;
            }
        }
        return sum;
    }
}
