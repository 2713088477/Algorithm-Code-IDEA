package ZuoVideo58;

//测试链接:https://leetcode.cn/problems/number-of-islands/
public class Code01_Solution200 {
    //时间复杂度:O(row*col)
    public int numIslands(char[][] grid) {
        int islands = 0;
        int row = grid.length,col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    dfsWithInjection(i, j, grid);
                }
            }
        } 
        return islands;
    }
    public void dfsWithInjection(int x,int y,char[][] grid){
        int row = grid.length,col = grid[0].length;
        if(x<0 || x>=row || y<0 || y>=col || grid[x][y] != '1'){
            return;
        }
        grid[x][y] = '2';
        dfsWithInjection(x+1, y, grid);
        dfsWithInjection(x-1, y, grid);
        dfsWithInjection(x, y+1, grid);
        dfsWithInjection(x, y-1, grid);
    }
}
