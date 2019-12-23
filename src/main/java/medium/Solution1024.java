package medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1024 {
    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
        int start = 0;
        int end = 0;
        int count = 0;
        int i = 0;
        while (i < clips.length) {
            if (clips[i][0] <= start) {
                end = Math.max(end, clips[i][1]);
                if (end >= T) {
                    return count + 1;
                }
                i++;
            } else if (start == end) {
                return -1;
            } else {
                count++;
                start = end;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        videoStitching(new int[][]{{0,1},{1,2}}, 5);
        videoStitching(new int[][]{{2, 8},{0,4}}, 5);
    }
}
