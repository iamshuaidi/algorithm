package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class no40_CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(target < 1)
            return res;
        Arrays.sort(candidates);
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
            if(candidates[i] > target){
                break;
            }
            tmp.add(candidates[i]);
            DFS(candidates, target - candidates[i], tmp, i + 1);
            tmp.remove(tmp.size() - 1);
            while(i+1 < candidates.length && candidates[i]==candidates[i+1]) i++;
        }
    }
}
