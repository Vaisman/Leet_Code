package easy;

public class Solution441 {
    public int arrangeCoins(int n) {
        int i=0;
        while(n > 0){
            i+=1;
            n-=i;
        }

        return n==0 ? i : i-1;

    }
}
