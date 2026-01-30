package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_39 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> pre = new ArrayList<>();
        f(candidates,target,0,pre,0);
        return ans;
    }
    public void f(int[] candidates,int target,int sum,List<Integer> pre,int start){
        if(sum > target) return;
        if(sum == target){
            List<Integer> list = new ArrayList<>(pre);
            ans.add(list);
            return;
        }
        for(int i = start;i< candidates.length;i++){
            if(sum + candidates[i]<=target){
                pre.add(candidates[i]);
                f(candidates,target,sum+candidates[i],pre,i);
                pre.remove(pre.size()-1);
            }else break;
        }
    }

}
