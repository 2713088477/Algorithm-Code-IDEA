package ZuoVideo67;

import java.util.Arrays;

//测试链接: https://leetcode.cn/problems/minimum-path-sum/description/
//只能往下或者往右
public class Code01_Minimum_path_sum {

    //1.暴力递归
    public int minPathSum1(int[][] grid) {
        return getMinPath(grid,grid.length-1,grid[0].length-1);
    }
    public static int getMinPath(int[][] grid,int x,int y){
        if(x==0 && y==0){
            return grid[x][y];
        }
        int left = y-1 >= 0 ? getMinPath(grid,x,y-1):Integer.MAX_VALUE;
        int up = x-1 >=0 ? getMinPath(grid,x-1,y):Integer.MAX_VALUE;
        return Math.min(left,up) + grid[x][y];
    }

    //2.暴力递归 + 缓存表
    public int minPathSum2(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[][] dp = new int[row][col];
        for(int[] d:dp) Arrays.fill(d,-1);
        return getMinPathWithCache(grid,row-1,col-1,dp);
    }
    public static int getMinPathWithCache(int[][] grid,int x,int y,int[][] dp){
        if(x==0 && y==0){
            return grid[x][y];
        }
        if(dp[x][y] != -1) return dp[x][y];
        int left = y-1 >= 0 ? getMinPathWithCache(grid,x,y-1,dp):Integer.MAX_VALUE;
        int up = x-1 >=0 ? getMinPathWithCache(grid,x-1,y,dp):Integer.MAX_VALUE;
        dp[x][y] = Math.min(left,up) + grid[x][y];
        return dp[x][y];
    }

    //3.从底到顶的动态规划
    public int minPathSum3(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i=1;i<col;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i=1;i<row;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }

    //4.从底到顶的动态规划,空间压缩
    //依赖左和上，用一维空间去压缩二维空间
    //左边就是左边的，上边的就是当前格子
    public int minPathSum4(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int[] dp = new int[col];
        dp[0] = grid[0][0];
        for(int i=1;i<col;i++){
            dp[i] = dp[i-1] + grid[0][i];
        }
        for(int i=1;i<row;i++){
            dp[0] = dp[0] + grid[i][0];
            for(int j=1;j<col;j++){
                dp[j] = Math.min(dp[j-1],dp[j]) + grid[i][j];
            }
        }
        return dp[col-1];
    }

}
