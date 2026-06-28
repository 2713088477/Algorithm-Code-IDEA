package ZuoVideo64;

import java.util.Arrays;
import java.util.PriorityQueue;

//测试链接:https://leetcode.cn/problems/swim-in-rising-water/description/
public class Code03_Solution778 {
    public static int[] direction = new int[]{1,0,-1,0,1};
    public int swimInWater(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[][] distance = new int[row][col];
        for(int[] dis:distance){
            Arrays.fill(dis,Integer.MAX_VALUE);
        }
        boolean[][] exist = new boolean[row][col];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        minHeap.add(new int[]{0,0,grid[0][0]});
        while (!minHeap.isEmpty()){
            int[] poll = minHeap.poll();
            int x = poll[0],y = poll[1],value = poll[2];
            if(exist[x][y]) continue;
            exist[x][y] = true;
            distance[x][y] = value;
            if(x == row-1 && y==col-1){
                return value;
            }
            for(int i=0,nx,ny;i<4;i++){
                nx = x + direction[i];
                ny = y + direction[i+1];
                if(nx<0 || nx>=row || ny<0 || ny>=col || exist[nx][ny]){
                    continue;
                }
                int newDis = Math.max(value,grid[nx][ny]);
                if(newDis < distance[nx][ny]){
                    minHeap.add(new int[]{nx,ny,newDis});
                }
            }

        }
        return -1;
    }
}
