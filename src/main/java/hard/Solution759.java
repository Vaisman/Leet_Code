package hard;

import common.Interval;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Solution759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> result = new ArrayList<>();
        Queue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        avails.forEach(e -> pq.addAll(e));

        Interval temp = pq.poll();
        while(!pq.isEmpty()) {
            if(temp.end < pq.peek().start) { // no intersect
                result.add(new Interval(temp.end, pq.peek().start));
                temp = pq.poll(); // becomes the next temp interval
            }else { // intersect or sub merged
                temp = temp.end < pq.peek().end ? pq.peek() : temp;
                pq.poll();
            }
        }
        return result;
    }

    @Test
    public void test() {
        List<List<Interval>> lint = new ArrayList<>();
        List<Interval> l1 = Arrays.asList(new Interval(1,2), new Interval(5,6));
        List<Interval> l2 = Arrays.asList(new Interval(1,3));
        List<Interval> l3 = Arrays.asList(new Interval(4,10));
        lint = Arrays.asList(l1, l2, l3);
        employeeFreeTime(lint);
    }
}
