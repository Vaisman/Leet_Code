package Amazon;

public class AmazonMusicPairs {
    public int numPairsDivisibleBy60(int[] arr) {
        int count = 0;
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            arr[i] = arr[i] % 60;
        }

        int[] res = new int[60];
        for (int j : arr)
            res[j]++;

        for (int i = 1; i < 30; i++) {
            count = count + (res[i] * res[60 - i]);
        }

        count = count + (res[0] * (res[0] - 1) / 2);
        count = count + (res[30] * (res[30] - 1) / 2);
        return count;
    }
}
