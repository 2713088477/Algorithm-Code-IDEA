package ZuoVideo64;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

//测试链接: https://leetcode.cn/problems/DFPeFJ/
public class Code05_Solution35 {
    public int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
        int len = charge.length;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i=0;i<len;i++){
            graph.add(new ArrayList<>());
        }
        //邻接表建图
        for(int[] path:paths){
            int from = path[0],to = path[1],value = path[2];
            graph.get(from).add(new int[]{to,value});
        }
        int[][] distance = new int[len][cnt+1];
        for(int[] dis:distance){
            Arrays.fill(dis,Integer.MAX_VALUE);
        }
        boolean[][] visit = new boolean[len][cnt+1];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        minHeap.add(new int[]{start,0,0});
        while(!minHeap.isEmpty()){
            int[] poll = minHeap.poll();
            int nodeId = poll[0],curCnt = poll[1],curCost = poll[2];
            if(visit[nodeId][curCnt]){
                continue;
            }
            visit[nodeId][curCnt] = true;
            distance[nodeId][curCnt] = curCost;
            if(nodeId == end){
                return curCost;
            }
            //扩点决策1:在当前充一格电
            minHeap.add(new int[]{nodeId,curCnt+1,curCost+charge[nodeId]});
            //扩点决策2:不充电直接进入下一层
            for(int[] edge: graph.get(nodeId)){
                int to = edge[0],weight = edge[1];
                if(curCnt>=weight && !visit[to][curCnt-weight]){
                    minHeap.add(new int[]{to,curCnt-weight,curCost+weight});
                }
            }

        }
        return -1;

    }
}
