package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution963 {
    public double minAreaFreeRect(int[][] points) {
        // O(n2)
        // Determine a rect: (1) diagonal have same length (2) diagonal midpoints are
        // same
        // HashMap: length -> (midPoint, original points a b)
        // => if two diagonal lines have the same length and midPoing (not the same line),
        //  are valid!
        // NOTE not picking k=a/b & k=b/a diagonals!!!
        // update minArea
        if (points.length < 4) {
            return 0;
        }

        Map<Integer, List<Data>> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i][0] < points[j][0] ? points[i] : points[j];
                int[] b = points[i][0] < points[j][0] ? points[j] : points[i];
                makeMap(map, a, b);
            }
        }

        // get rects and update minArea
        double minArea = Double.MAX_VALUE;
        boolean found = false;
        for (Integer l1 : map.keySet()) {
            List<Data> list = map.get(l1);
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    Data fd = list.get(i);
                    Data bd = list.get(j);
                    if (Math.abs(fd.midPoint[0] - bd.midPoint[0]) <= 0.00001
                            && Math.abs(fd.midPoint[1] - bd.midPoint[1]) <= 0.00001) {
                        double area = getArea(fd.a, fd.b, bd.a, bd.b);
                        minArea = Math.min(minArea, area);
                        found = true;
                    }

                }
            }
        }

        return found ? minArea : 0;
    }

    private double getArea(int[] a, int[] b, int[] c, int[] d) {
        // left-top c, left-down a, right-top b, right-down d
        double l1 = Math.sqrt((double) (c[1] - a[1]) * (c[1] - a[1]) + (double) (c[0] - a[0]) * (c[0] - a[0]));
        double l2 = Math.sqrt((double) (d[1] - a[1]) * (d[1] - a[1]) + (double) (d[0] - a[0]) * (d[0] - a[0]));
        return l1 * l2;
    }

    private void makeMap(Map<Integer, List<Data>> map, int[] a, int[] b) {
        int y = Math.abs(b[1] - a[1]);
        int x = Math.abs(b[0] - a[0]);

        int length2 = x * x + y * y;
        double[] midPoint = new double[2];
        midPoint[0] = a[0] + (double) (b[0] - a[0]) / 2;
        midPoint[1] = a[1] + (double) (b[1] - a[1]) / 2;

        if (!map.containsKey(length2)) {
            map.put(length2, new ArrayList<>());
        }

        map.get(length2).add(new Data(midPoint, a, b));
    }
}

class Data {
    double[] midPoint;
    int[] a;
    int[] b;

    public Data(double[] m, int[] a, int[] b) {
        midPoint = m;
        this.a = a;
        this.b = b;
    }
}