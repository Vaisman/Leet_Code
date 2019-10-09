package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        traverse(result, new ArrayList<>(), nums);
        return result;
    }

    void traverse(List<List<Integer>> result, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!cur.contains(nums[i])) {
                cur.add(nums[i]);
                traverse(result, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
