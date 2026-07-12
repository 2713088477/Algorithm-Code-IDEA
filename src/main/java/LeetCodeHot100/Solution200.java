package LeetCodeHot100;

//测试链接: https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked
public class Solution200 {
    public int numIslands(char[][] grid) {
        int row = grid.length,col = grid[0].length;
        boolean[][] visit = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='0'){
                    grid[i][j] = 'w';
                }else{
                    grid[i][j] = '0';
                }
            }
        }
        int ans = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='0'){
                    dfs(grid,i,j,++ans);
                }
            }
        }
        return ans;
    }
    public static int[] direction = new int[]{1,0,-1,0,1};
    public static void dfs(char[][] grid,int x,int y,int id){
        if(x<0 || x>=grid.length || y<0 || y>= grid[0].length || grid[x][y] != '0') return;
        grid[x][y] = (char)('0'+id);
        for(int i=0;i<4;i++){
            dfs(grid,x+direction[i],y+direction[i+1],id);
        }
    }
}
