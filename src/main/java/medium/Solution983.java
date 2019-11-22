package medium;

public class Solution983 {
    public int mincostTickets(int[] days, int[] costs) {
        boolean[] travel = new boolean[366];

        for ( int day : days) {
            travel[day] = true;
        }

        int[] mincost = new int[366];
        mincost[0] = 0;

        for ( int i = 1; i <= 365; i++) {
            if ( !travel[i] ) {
                mincost[i] = mincost[i-1];
                continue;
            }
            int pass1 = costs[0] + mincost[i-1];
            int pass7 = costs[1] + mincost[Math.max(0,i-7)];
            int pass30 = costs[2] + mincost[Math.max(0,i-30)];
            mincost[i] = Math.min(pass1,Math.min(pass7,pass30));
        }
        return mincost[365];
    }
}
