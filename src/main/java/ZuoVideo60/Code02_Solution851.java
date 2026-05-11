package ZuoVideo60;

import java.util.ArrayList;

//测试链接:https://leetcode.cn/problems/loud-and-rich/
public class Code02_Solution851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
        for(int i=0;i<n;i++){
            edge.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i=0,fromNode,toNode;i<richer.length;i++){
            fromNode = richer[i][0];
            toNode = richer[i][1];
            edge.get(fromNode).add(toNode);
            indegree[toNode]++;
        }
        int[] deque = new int[n];
        int l=0,r=0;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = i;
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                deque[r++] = i;
            }
        }
        int pop;
        while(l<r){
            pop = deque[l++];
            for(int e:edge.get(pop)){
                ans[e] = quiet[ans[pop]]<quiet[ans[e]] ? ans[pop]:ans[e];
                if(--indegree[e]==0){
                    deque[r++] = e;
                }
            }
        }
        return ans;
        
    }
}
