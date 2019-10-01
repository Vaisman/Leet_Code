package easy;

public class Solution1009 {
    public int bitwiseComplement(int N) {
        int c = 1;
        while (c < N) c = (c << 1) + 1;
        return N ^ c;
    }
}
