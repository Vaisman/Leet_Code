package easy;

public class Solution414 {
    public int thirdMax(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;

        for (int each : nums) {
            if (first == null || each > first) {
                third = second;
                second = first;
                first = each;
            } else if (each != first && (second == null || each > second)) {
                third = second;
                second = each;
            } else if (each != first && each != second && (third == null || each > third)) {
                third = each;
            }
        }

        if (third != null) {
            return third;
        }

        return first;
    }
}
