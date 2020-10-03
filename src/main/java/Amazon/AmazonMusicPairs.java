package Amazon;

public class AmazonMusicPairs {
    public int numPairsDivisibleBy60(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 60;
        }

        int[] res = new int[60];
        for (int j : arr) {
            res[j]++;
        }

        int count = 0;
        for (int i = 1; i < 30; i++) {
            count = count + (res[i] * res[60 - i]);
        }

        count = count + (res[0] * (res[0] - 1) / 2);
        count = count + (res[30] * (res[30] - 1) / 2);
        return count;
    }
}
