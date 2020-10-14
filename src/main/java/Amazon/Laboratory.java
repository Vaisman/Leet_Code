package Amazon;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Laboratory {
    class PairInt {
        int first, second;

        PairInt() {
        }

        PairInt(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int chooseFlask(int numOrders, List<Integer> requirements,
                           int flaskTypes, int totalMarks, List<PairInt> markingsList) {
        List<Integer>[] markings = groupMarkings(flaskTypes, markingsList);
        int minWaste = Integer.MAX_VALUE;
        int flask = -1;
        for (int type = 0; type < flaskTypes; type++) {
            int waste = getWaste(requirements, markings[type]);
            if (waste < minWaste) {
                minWaste = waste;
                flask = type;
            }
        }
        return flask;
    }

    private List<Integer>[] groupMarkings(int flaskTypes, List<PairInt> markingsList) {
        List<Integer>[] markings = new List[flaskTypes];
        Arrays.setAll(markings, (i) -> new ArrayList<>());
        for (PairInt marking : markingsList) {
            markings[marking.first].add(marking.second);
        }
        return markings;
    }

    private int getWaste(List<Integer> requirements, List<Integer> markings) {
        int waste = 0;
        int i = 0;
        for (Integer req : requirements) {
            while (i < markings.size() && markings.get(i) < req) i++;
            if (i >= markings.size()) return Integer.MAX_VALUE;
            waste += markings.get(i) - req;
        }
        return waste;
    }

    @Test
    public void test() {
        assertEquals(0, chooseFlask(4, Arrays.asList(4, 6, 6, 7), 3, 9, Arrays.asList(
                new PairInt(0, 3), new PairInt(0, 5), new PairInt(0, 7), new PairInt(1, 6), new PairInt(1, 8), new PairInt(1, 9),
                new PairInt(2, 3), new PairInt(2, 5), new PairInt(2, 6))));
    }
}
