package Amazon;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class DiskSpaceAnalysis {

    public int analyse(int numComputer, int[] hardDiskSpace, int segmentLength) {
        Deque deq = new ArrayDeque<>();
        int maxMin = Integer.MIN_VALUE;
        for(int i = 0; i < numComputer; i++) {
            while(!deq.isEmpty() && hardDiskSpace[(int) deq.peekLast()] > hardDiskSpace[i]) {
                deq.pollLast();
            }
            if(!deq.isEmpty() && ((int)deq.peekFirst() <= (i - segmentLength))) {
                deq.pollFirst();
            }
            deq.offerLast(i);
            if(i >= (segmentLength - 1)) {
                maxMin = Math.max(maxMin, hardDiskSpace[(int) deq.peekFirst()]);
            }
        }
        return maxMin;
    }

    @Test
    public void test() {
        System.out.println(analyse(3, new int[] {8, 2, 4}, 2));
        System.out.println(analyse(6, new int[] {8, 2,4,3,7,6}, 2));//6
        System.out.println(analyse(6, new int[] {8, 2,4,3,7,6}, 3));//3
        System.out.println(analyse(7, new int[] {2,4,3,7,8,6,5}, 4));//5
        System.out.println(analyse(13, new int[] {2,4,3,7,8,6,5,16,19,33,32,34,35}, 5));
    }
}
