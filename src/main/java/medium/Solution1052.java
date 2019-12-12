package medium;

public class Solution1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int mins = customers.length;
        int directly_satisfied = 0;

        for(int i = 0; i < mins; i++) {
            if(grumpy[i] == 0) {
                directly_satisfied += customers[i];
                customers[i] = 0;
            }
        }

        int secretly_satisfied = 0, sum = 0;
        for(int i = 0, j = 0; j < mins; j++) {
            sum += customers[j];
            if(j - i == X)
                sum -= customers[i++];
            secretly_satisfied = Math.max(secretly_satisfied, sum);
        }

        return directly_satisfied + secretly_satisfied;
    }
}
