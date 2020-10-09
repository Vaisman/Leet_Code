package Amazon;

import org.junit.Test;

import java.util.*;

public class OptimalUtilization {

    /**
     * Given 2 lists a and b. Each element is a pair of integers where the first
     * integer represents the unique id and the second integer represents a value.
     * Your task is to find an element from a and an element form b such that the
     * sum of their values is less or equal to target and as close to target as
     * possible. Return a list of ids of selected elements. If no pair is possible,
     * return an empty list.
     *
     * Example 1:
     *
     * Input: a = [[1, 2], [2, 4], [3, 6]] b = [[1, 2]] target = 7
     *
     * Output: [[2, 1]]
     *
     * Explanation: There are only three combinations [1, 1], [2, 1], and [3, 1],
     * which have a total sum of 4, 6 and 8, respectively. Since 6 is the largest
     * sum that does not exceed 7, [2, 1] is the optimal pair.
     */


    public List<int[]> solution(List<int[]> a, List<int[]> b, int target){
        Map<Integer, List<int[]>> map = new HashMap<>();//key is sum , value is list of ids from a and b.

        for (int i = 0; i < a.size(); i ++){
            for (int j = 0; j < b.size(); j ++){
                List<int[]> sums = map.getOrDefault(a.get(i)[1] + b.get(j)[1], new ArrayList<int[]>());
                sums.add(new int[] {a.get(i)[0], b.get(j)[0]});
                map.put(a.get(i)[1] + b.get(j)[1], sums);
            }
        }

        List<Integer> allSums = new ArrayList<>();
        for (Integer i : map.keySet()){
            if (i < target){
                allSums.add(i);
            } else if (i == target){
                return map.get(target);
            }
        }
        if (allSums.size() == 0){
            return new ArrayList<>();//target is less than every possible sums.
        }
        return map.get(Collections.max(allSums));
    }

    private List<int[]> getPairs(List<int[]> a, List<int[]> b, int target) {
        Collections.sort(a, (i,j) -> i[1] - j[1]);
        Collections.sort(b, (i,j) -> i[1] - j[1]);
        List<int[]> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int m = a.size();
        int n = b.size();
        int i =0;
        int j =n-1;
        while(i<m && j >= 0) {
            int sum = a.get(i)[1] + b.get(j)[1];
            if(sum > target) {
                --j;
            } else {
                if(max <= sum) {
                    if(max < sum) {
                        max = sum;
                        result.clear();
                    }
                    result.add(new int[]{a.get(i)[0], b.get(j)[0]});
                    int index = j-1;
                    while(index >=0 && b.get(index)[1] == b.get(index+1)[1]) {
                        result.add(new int[]{a.get(i)[0], b.get(index--)[0]});
                    }
                }
                ++i;
            }
        }
        return result;
    }

    class Pair {
        int id1;
        int id2;
        int value;

        Pair(int i, int j, int v) {
            this.id1 = i;
            this.id2 = j;
            this.value = v;
        }
    }

    private List<List<Integer>> getTargetSumIds(int[][] a, int[][] b, int target) {
        List<List<Integer>> lst = new ArrayList<>();
        Arrays.sort(a, (x, y) -> x[1] - y[1]);
        Arrays.sort(b, (x, y) -> x[1] - y[1]);

        int lowIndex = 0;
        int highIndex = a.length - 1;
        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> (y.value - x.value));
        while (lowIndex < b.length && highIndex >= 0) {
            int sum = b[lowIndex][1] + a[highIndex][1];
            if (sum <= target) {
                q.add(new Pair(a[highIndex][0], b[lowIndex][0], sum));
                lowIndex++;
            } else {
                highIndex--;
            }
        }

        int largetSumValue = q.peek().value;
        while (!q.isEmpty()) {
            int curValue = q.peek().value;
            if (curValue < largetSumValue)
                break;
            ArrayList<Integer> l = new ArrayList<Integer>();
            l.add(q.peek().id1);
            l.add(q.peek().id2);
            q.poll();
            lst.add(l);
        }
        return lst;
    }

    @Test
    public void test() {
        int[][] a = { { 1, 8 }, { 2, 15 }, { 3, 9 } };
        List<int[]> aList = new ArrayList<int[]>();
        Collections.addAll(aList, a);
        int[][] b = { { 1, 8 }, { 2, 11 }, { 3, 12 } };
        List<int[]> bList = new ArrayList<int[]>();
        Collections.addAll(bList, b);
        int target = 20;

        List<int[]> res = getPairs(aList, bList, target);
        for (int[] list : res) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.print("\n");
        }
    }
}
