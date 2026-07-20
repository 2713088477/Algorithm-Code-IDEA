package ZuoVideo65;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Code01_AStarAlgorithm {

    public static int[] direction = new int[]{1,0,-1,0,1};
    /**
     * 寻找从开始点到结束点，最短需要途径几个点
     * @param grid    0表示有障碍，1表示可以到达该点
     * @param startX  开始点的x坐标
     * @param startY  开始点的y坐标
     * @param targetX 目标点的x坐标
     * @param targetY 开始点的y坐标
     * @return 如果无法到达返回-1
     */
    public static int minDistance1(int[][] grid,int startX,int startY,int targetX,int targetY){
        if(grid[startX][startY] == 0 || grid[targetX][targetY] == 0){
            return -1;
        }
        int row = grid.length,col = grid[0].length;
        int[][] distance = new int[row][col];
        boolean[][] visit = new boolean[row][col];
        for(int[] dis:distance) Arrays.fill(dis,Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[2]-b[2]);
        minHeap.add(new int[]{startX,startY,1});
        while(!minHeap.isEmpty()){
            int[] poll = minHeap.poll();
            int x = poll[0],y=poll[1],curCost = poll[2];
            if(visit[x][y]) continue;
            distance[x][y] = curCost;
            if(x == targetX && y == targetY){
                return curCost;
            }
            for(int i=0,nx,ny,nCost;i<4;i++){
                nx = x + direction[i];ny=y+direction[i+1];nCost = curCost+1;
                if(nx <0 || nx>=row || ny<0 || ny>=col || grid[nx][ny]==0) continue;
                if(distance[nx][ny] > curCost){
                    minHeap.add(new int[]{nx,ny,nCost});
                    distance[nx][ny] = curCost;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int MAX_ROW = 100,MAX_COL = 100;
        Random random = new Random();
        int[][] grid = new int[MAX_ROW][MAX_COL];
        for(int i=0;i<MAX_ROW;i++){
            for(int j=0;j<MAX_COL;j++){
                grid[i][j] = random.nextInt(5) ==0 ? 0 :1;
            }
        }
        System.out.println("随机数据生成完毕");
        for(int i=0;i<MAX_ROW;i++){
            for(int j=0;j<MAX_COL;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        int startX = random.nextInt(MAX_ROW);
        int startY = random.nextInt(MAX_COL);
        int targetX = random.nextInt(MAX_ROW);
        int targetY = random.nextInt(MAX_COL);
        System.out.println(String.format("测试开始: startX:%d startY:%d targetX:%d targetY:%d",startX,startY,targetX,targetY));
        long start = System.currentTimeMillis();
        int ans = minDistance1(grid, startX, startY, targetX, targetY);
        long end =  System.currentTimeMillis();
        System.out.println(String.format("测试结束: 答案:%d 耗时:%d ms",ans,(end-start)));
    }


}
