package ZuoVideo64;

import java.util.ArrayList;
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
        boolean[][] visit = new boolean[len][cnt+1];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        minHeap.add(new int[]{start,0,0});
        while(!minHeap.isEmpty()){
            int[] poll = minHeap.poll();

        }

    }
}
