package medium;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return res;
        }

        dfs(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void dfs(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
        if(target > 0){
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                cur.add(candidates[i]);
                dfs(result, cur, candidates, target - candidates[i], i);
                cur.remove(cur.size() - 1);
            }
        }
        else if(target == 0 ){
            result.add(new ArrayList<>(cur));
        }
    }
}
