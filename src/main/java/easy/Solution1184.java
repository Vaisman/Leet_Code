package easy;

public class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination)
        return distanceBetweenBusStops(distance, destination, start);

        int res = 0;
        int total = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                res += distance[i];
            }
            total += distance[i];
        }

        return Math.min(res, total - res);
    }
}
