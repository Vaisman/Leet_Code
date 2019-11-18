package medium;

public class Solution1262 {
    public int maxSumDivThree(int[] nums) {
        int zero = 0, one = -1, two = -1;
        for(int n:nums){
            if(n%3==0){
                zero += n;
                if(one!=-1) one += n;
                if(two!=-1) two += n;
            }
            else if(n%3==1){
                int tmp_zero = zero;
                if(two!=-1)
                    zero = Math.max(zero,two+n);
                if(one!=-1)
                    two = Math.max(two,one+n);
                one = Math.max(one,tmp_zero+n);
            }
            else{ // n%3==2
                int tmp_zero = zero;
                if(one!=-1)
                    zero = Math.max(zero,one+n);
                if(two!=-1)
                    one = Math.max(one,two+n);
                two = Math.max(two,tmp_zero+n);
            }
        }
        return zero;
    }
}
