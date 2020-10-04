package Amazon;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class MaximumUnits {
    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        // key: size, value: idx
        // sort by units per box
        // get number of boxes from map based on size
        Map<Long, Long> map = new HashMap<>();

        for (int i = 0; i < boxes.size(); i++) {
            Long boxIdx = boxes.get(i);
            Long size = unitsPerBox.get(i);

            map.put(size, boxIdx);
        }

        unitsPerBox.sort(Collections.reverseOrder());

        long fillUnits = 0;

        for (Long boxSize : unitsPerBox) {
            // greedy fill the truck with the highest value boxes
            Long boxCount = map.get(boxSize);

            if (truckSize < 0) {
                return fillUnits;
            }

            // if we have exact space in the truck for all packages of this size
            if (truckSize == boxCount) {
                fillUnits += (boxCount * boxSize);
                return fillUnits;
            }

            // if space is still left, add to result, and decrement truck size by expected amount
            if (truckSize > boxCount) {
                fillUnits += (boxCount * boxSize);
                truckSize -= boxCount;
            } else {
                fillUnits += (truckSize * boxSize);
                return fillUnits;
            }
        }

        return fillUnits;
    }

    @Test
    public void test() {
        assertEquals(7, getMaxUnits(Arrays.asList(1L,2L,3L), Arrays.asList(3L,2L,1L), 3));
        assertEquals(19, getMaxUnits(Arrays.asList(2L,5L,3L), Arrays.asList(3L,2L,1L), 50));
    }
}
