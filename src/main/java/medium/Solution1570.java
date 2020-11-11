package medium;

import java.util.HashMap;
import java.util.Map;

// Dot Product of Two Sparse Vectors

public class Solution1570 {

    private final Map<Integer, Integer> indexToValue;

    Solution1570(int[] nums) {
        this.indexToValue = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                indexToValue.put(i, nums[i]);
            }
        }
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(Solution1570 vec) {
        Map<Integer, Integer> smallVector;
        Map<Integer, Integer> largeVector;

        if (vec.getValueMap().size() < indexToValue.size()) {
            smallVector = vec.getValueMap();
            largeVector = indexToValue;
        } else {
            smallVector = indexToValue;
            largeVector = vec.getValueMap();
        }

        int dotProduct = 0;
        for (int index : smallVector.keySet()) {
            if (largeVector.containsKey(index)) {
                dotProduct += smallVector.get(index) * largeVector.get(index);
            }
        }

        return dotProduct;
    }

    private Map<Integer, Integer> getValueMap() {
        return indexToValue;
    }
}
