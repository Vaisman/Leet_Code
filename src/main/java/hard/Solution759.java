package hard;

import common.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

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
}
