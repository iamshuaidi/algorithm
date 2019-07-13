package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NO39_CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target)     {
        if(target < 1)
            return res;
        DFS(candidates, target, new ArrayList<>(), 0);

        return res;
    }

    private void DFS(int[] candidates, int target, List<Integer>tmp, int k){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = k; i < candidates.length; i++){
            tmp.add(candidates[i]);
            DFS(candidates, target - candidates[i], tmp, i);
            tmp.remove(tmp.size() - 1);

        }
    }
}
