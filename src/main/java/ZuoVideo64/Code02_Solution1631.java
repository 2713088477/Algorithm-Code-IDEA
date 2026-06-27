package ZuoVideo64;


import java.util.Arrays;
import java.util.PriorityQueue;

//测试链接:https://leetcode.cn/problems/path-with-minimum-effort/description/
public class Code02_Solution1631 {
    //下,左,上，右
    public static int[] direction = new int[]{1,0,-1,0,1};
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length,col = heights[0].length;
        int[][] distance = new int[row][col];
        boolean[][] computed = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                distance[i][j] = Integer.MAX_VALUE;
                computed[i][j] = false;
            }
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        minHeap.add(new int[]{0,0,0});
        while(!minHeap.isEmpty()){
            int[] poll = minHeap.poll();
            int x = poll[0],y = poll[1],value = poll[2];
            if(computed[x][y]) continue;
            computed[x][y] = true;
            distance[x][y] = value;
            if(x == row-1 && y == col-1){
                return value;
            }
            for(int i=0,nx,ny;i<4;i++){
                nx = x + direction[i];
                ny = y + direction[i+1];
                if(nx>=0 && nx<row && ny>=0 && ny<col){
                    int curValue = Math.max(value,Math.abs(heights[x][y]-heights[nx][ny]));
                    if(distance[nx][ny] > curValue){
                        minHeap.add(new int[]{nx,ny,curValue});
                    }
                }
            }
        }
        return -1;
    }


}


