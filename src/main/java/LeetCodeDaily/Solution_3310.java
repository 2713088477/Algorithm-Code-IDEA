package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

//测试链接: https://leetcode.cn/problems/remove-methods-from-project/
public class Solution_3310 {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        //1.邻接表建图
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for (int[] invocation : invocations) {
            int from = invocation[0],to = invocation[1];
            graph.get(from).add(to);
        }
        boolean[] isBug = new boolean[n];
        //2.dfs搜索
        dfs(k,isBug,graph);
        //3.返回List
        List<Integer> ans = new ArrayList<>();
        boolean canRemove = true;
        for (int[] invocation : invocations) {
            int from = invocation[0],to = invocation[1];
            if(!isBug[from] && isBug[to]){
                canRemove = false;
                break;
            }
        }
        if(!canRemove){
            for(int i=0;i<n;i++){
                ans.add(i);
            }
        }else{
            for(int i=0;i<isBug.length;i++){
                if(!isBug[i]){
                    ans.add(i);
                }
            }
        }
        return ans;
    }

    public void dfs(int bugNode,boolean[] isBug,List<List<Integer>> graph){
        isBug[bugNode] = true;
        for(int newBugNode:graph.get(bugNode)){
            if(isBug[newBugNode]) continue;
            dfs(newBugNode,isBug,graph);
        }
    }

}
