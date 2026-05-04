package ZuoVideo59;

import java.util.ArrayList;

//测试链接:https://leetcode.cn/problems/course-schedule-ii/description/
//TODO:目前有问题
public class Code02_Solution210 {
    public static ArrayList<ArrayList<Integer>> edge = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edge.clear();
        for(int i=0;i<numCourses;i++){
            edge.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        //建图
        for(int i=0,from,to;i<prerequisites.length;i++){
            from = prerequisites[i][1];
            to = prerequisites[i][0];
            edge.get(from).add(to);
            indegree[to]++;
        }
        //用入度消除法实现拓扑排序,需要用到队列
        int[] deque = new int[numCourses];
        int cnt = 0;
        int l=0,r=0;
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                deque[r++] = i;
            }
        }
        while(l<r){
            for(int e: edge.get(l)){
                if(--indegree[e]==0){
                    deque[r++] = e;
                }
            }
            cnt++;
            l++;
        }
        return cnt == numCourses?deque:new int[0];
    }
}
