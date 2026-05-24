package ZuoVideo62;

import java.util.ArrayDeque;
import java.util.Arrays;

//测试链接: https://leetcode.cn/problems/minimum-obstacle-removal-to-reach-corner/description/
public class Code03_Solution2290 {
    //上，右,下,左
    public static int[] direction = new int[]{-1,0,1,0,-1};
    public int minimumObstacles(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[][] distance = new int[row][col];
        for(int[] dis:distance){
            Arrays.fill(dis,Integer.MAX_VALUE);
        }
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0,0});
        distance[0][0] = 0;
        int[] pop;
        while (!deque.isEmpty()){
            pop = deque.removeFirst();
            if(pop[0] == row-1 && pop[1] == col-1){
                return distance[row-1][col-1];
            }
            for(int i=0,nx,ny;i<4;i++){
                nx = pop[0] + direction[i];
                ny = pop[1] + direction[i+1];
                if(nx<0 || nx>=row || ny<0 || ny>=col)continue;
                if(distance[nx][ny] > distance[pop[0]][pop[1]] + grid[nx][ny]){
                    distance[nx][ny] = distance[pop[0]][pop[1]] + grid[nx][ny];
                    if(grid[nx][ny] == 0){
                        deque.addFirst(new int[]{nx,ny});
                    }else{
                        deque.addLast(new int[]{nx,ny});
                    }
                }
            }
        }
        return distance[row-1][col-1];

    }
}
