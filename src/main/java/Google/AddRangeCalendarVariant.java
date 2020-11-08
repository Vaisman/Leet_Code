package Google;

import java.util.TreeMap;

public class AddRangeCalendarVariant {
    /**
     * Q) Design a data structure with two operations 1. addRange(int start, int end) and 2. isPresent(int point)
     * Here range means an interval, so the data structure contains information of all ranges added
     * uptil that point. isPresent(int point) returns true if the point is contained in any of the ranges or false otherwise.
     * How to do both operations with O(logn) complexity or better ?
     */


    private TreeMap<Integer, Integer> map;

    public AddRangeCalendarVariant() {
        map = new TreeMap();
    }


    public boolean addRange(int start, int end) {
        Integer floorKey = map.floorKey(start);
        Integer celinigKey = map.ceilingKey(start);

        if (floorKey == null || (map.get(floorKey)) <= start &&
                (celinigKey == null || end <= celinigKey)) {
            map.put(start, end);
            return true;
        }
        return false;
    }

    public boolean isPresent(int point) {
        Integer floorKey = map.floorKey(point);
        Integer ending = map.ceilingKey(point);

        return point >= floorKey && point <= ending;
    }
}