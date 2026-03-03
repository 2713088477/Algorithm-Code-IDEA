package ZuoVideo48;

//测试链接:https://leetcode.cn/problems/stamping-the-grid
public class Code04_Solution2132 {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        //加工出前缀和快速判断
        build(grid);
        //构造出二维差分数组
        int[][] diff = new int[grid.length+1][grid[0].length+1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(isOk(grid,i,j,stampHeight,stampWidth)){
                    diff[i][j] +=1;
                    diff[i][j+stampWidth] -=1;
                    diff[i+stampHeight][j] -=1;
                    diff[i+stampHeight][j+stampWidth] +=1;
                }
            }
        }
        build(diff);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(sum(grid,i,j,i,j)==0&& diff[i][j]==0) return false;
            }
        }
        return true;
    }
    public static boolean isOk(int[][] grid,int lx,int ly,int stampHeight,int stampWidth){
        if(lx+stampHeight-1 >=grid.length || ly+stampWidth-1>=grid[0].length){
            return false;
        }
        if(sum(grid,lx,ly,lx,ly)==0) {
            return sum(grid,lx,ly,lx+stampHeight-1,ly+stampWidth-1)==0;
        }
        return false;
    }
    public static void build(int[][] grid){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] += get(grid,i-1,j)+get(grid,i,j-1)-get(grid,i-1,j-1);
            }
        }
    }
    public static int sum(int[][] grid,int lx,int ly,int rx,int ry){
        return  get(grid,rx,ry)- get(grid,rx,ly-1) -get(grid,lx-1,ry)+ get(grid,lx-1,ly-1);
    }
    public static int get(int[][] grid,int x,int y){
        return x<0||y<0?0:grid[x][y];
    }



}
