package ZuoVideo58;

//测试链接:https://leetcode.cn/problems/bricks-falling-when-hit/
public class Code04_Solution803 {
    public static int row,col;
    public static int[][] grid;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        row = grid.length;col = grid[0].length;
        this.grid = grid;
        //打的地方先减一
        for(int i=0;i<hits.length;i++){
            grid[hits[i][0]][hits[i][1]]--;
        }
        //从顶部开始，现在还是1的洪水填充为2
        for(int i=0;i<col;i++){
            if(grid[0][1]==1){
                dfsInjection(0, i, 2);
            }
        }
        //倒放,洪水填充
        int[] ans = new int[hits.length];
        for(int i=hits.length-1;i>=0;i--){
            grid[hits[i][0]][hits[i][1]]++;
            if(isOk(hits[i][0], hits[i][1])){
                ans[i] = dfsFill(hits[i][0], hits[i][1], 2)-1;
            }
        }
        return ans;
    }
    public void dfsInjection(int x,int y,int tag){
        if(x<0 || x>=row || y<0 || y>=col || grid[x][y]!=1) return;
        grid[x][y] = tag;
        dfsInjection(x+1,y,tag);
        dfsInjection(x-1,y,tag);
        dfsInjection(x,y+1,tag);
        dfsInjection(x,y-1,tag);
    }
    public int dfsFill(int x,int y,int tag){
        if(x<0 || x>=row || y<0 || y>=col || grid[x][y]!=1) return 0;
        int ans = 0;
        grid[x][y] = tag;ans++;
        ans += dfsFill(x+1,y,tag);
        ans += dfsFill(x-1,y,tag);
        ans += dfsFill(x,y+1,tag);
        ans += dfsFill(x,y-1,tag);
        return ans;
    }
    public boolean isOk(int x,int y){
        return grid[x][y] == 1 &&
        ( x==0 || x-1>=0&&grid[x-1][y]==2 || y-1>=0&&grid[x][y-1]==2 || x+1<row && grid[x+1][y]==2 || y+1<col && grid[x][y+1]==2 );
    }
}
