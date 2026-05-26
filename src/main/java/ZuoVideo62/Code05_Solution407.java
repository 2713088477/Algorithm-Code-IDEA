package ZuoVideo62;

import java.util.Arrays;
import java.util.PriorityQueue;

//测试链接:https://leetcode.cn/problems/trapping-rain-water-ii/
public class Code05_Solution407 {
    //上，右，下,左
    public static int[] direction = new int[]{-1,0,1,0,-1};
    public int trapRainWater(int[][] heightMap) {
        int row = heightMap.length,col = heightMap[0].length;
        boolean[][] visit = new boolean[row][col];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(i==0 || i==row-1 || j==0 || j==col-1){
                    if(!visit[i][j]){
                        visit[i][j] = true;
                        heap.add(new int[]{i,j,heightMap[i][j]});
                    }
                }
            }
        }
        int ans = 0;
        while(!heap.isEmpty()){
            int[] pop = heap.poll();

            int x = pop[0];
            int y = pop[1];
            int h = pop[2];
            ans+= h-heightMap[x][y];
            for(int i=0,nx,ny;i<4;i++){
                nx = x + direction[i];
                ny = y + direction[i+1];
                if(nx>=0 && nx<row && ny >=0 && ny<col
                    && !visit[nx][ny]
                ){
                    heap.add(new int[]{nx,ny,Math.max(h,heightMap[nx][ny])});
                    visit[nx][ny] = true;
                }
            }

        }
        return ans;
    }

}
