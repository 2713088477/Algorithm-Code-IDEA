package ZuoVideo60;

import java.util.ArrayList;

//测试链接:https://leetcode.cn/problems/parallel-courses-iii/description/
public class Code03_Solution2050 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>(n+1);
        for(int i=0;i<=n;i++){
            edge.add(new ArrayList<>());
        }
        int[] indegree = new int[n+1];
        for(int i=0,f,t;i<relations.length;i++){
            f = relations[i][0];
            t = relations[i][1];
            edge.get(f).add(t);
            indegree[t]++;
        }
        int[] curTime = new int[n+1];
        int[] deque = new int[n];
        int l=0,r=0;
        for(int i=1;i<indegree.length;i++){
            if(indegree[i]==0){
                deque[r++] = i;
            }
        }
        int ans = 0;
        int pop;
        while(l<r){
            pop = deque[l++];
            curTime[pop] += time[pop-1];
            ans = Math.max(ans,curTime[pop]);
            for(int t:edge.get(pop)){
                curTime[t] = Math.max(curTime[t],curTime[pop]);
                if(--indegree[t] ==0 ){
                    deque[r++] = t;
                }
            } 
        }
        return ans;
    }
}
