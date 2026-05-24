package ZuoVideo62;

import java.util.ArrayDeque;
import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
public class Code04_Solution1368 {
    public static int[][] direction = new int[][]{{},{0,1},{0,-1},{1,0},{-1,0}};
    public int minCost(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[][] distance = new int[row][col];
        for(int[] dis:distance){
            Arrays.fill(dis,Integer.MAX_VALUE);
        }
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        deque.addFirst(new int[]{0,0});
        distance[0][0] = 0;
        int[] pop;
        while(!deque.isEmpty()){
            pop = deque.removeFirst();
            if(pop[0]==row-1 && col==col-1){
                return distance[row-1][col-1];
            }
            for(int i=1,nx,ny,value;i<=4;i++){
                nx = pop[0] + direction[i][0];
                ny = pop[1] + direction[i][1];
                value = grid[pop[0]][pop[1]] == i ? 0:1;
                if(nx>=0 && nx<row && ny>=0 && ny < col
                 && distance[nx][ny] > distance[pop[0]][pop[1]] + value
                ){
                    distance[nx][ny] = distance[pop[0]][pop[1]] + value;
                    if(value == 0){
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
