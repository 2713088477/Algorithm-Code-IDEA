package ZuoVideo58;

//测试链接：https://leetcode.cn/problems/making-a-large-island/
public class Code03_Solution827 {
    public int largestIsland(int[][] grid) {
        int row = grid.length,col = grid[0].length;
        int id = 2;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,id++);
                }
            }
        }
        int[] size = new int[id];
        int ans = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]!=0){
                    ans = Math.max(ans, ++size[grid[i][j]]);
                }
                
            }
        }
        boolean[] isUsed = new boolean[id];
        int sum = 0;
        int leftId,rightId,upId,downId;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==0){
                    leftId = j-1>=0 ? grid[i][j-1]:0;
                    rightId = j+1<col?grid[i][j+1]:0;
                    upId = i-1>=0 ? grid[i-1][j]:0;
                    downId = i+1<row ? grid[i+1][j]:0;
                    sum = 1;
                    if(leftId !=0 && !isUsed[leftId]){
                        sum += size[leftId];
                        isUsed[leftId] = true;
                    }
                    if(rightId !=0 && !isUsed[rightId]){
                        sum += size[rightId];
                        isUsed[rightId] = true;
                    }
                    if(upId !=0 && !isUsed[upId]){
                        sum += size[upId];
                        isUsed[upId] = true;
                    }
                    if(downId !=0 && !isUsed[downId]){
                        sum += size[downId];
                        isUsed[downId] = true;
                    }
                    ans = Math.max(ans, sum);
                    isUsed[leftId] =false;
                    isUsed[rightId] =false;
                    isUsed[upId] =false;
                    isUsed[downId] =false;

                }
            }
        }
        return ans;
    }
    public static void dfs(int[][] grid,int x,int y,int id){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!=1) return;
        grid[x][y] = id;
        dfs(grid, x+1, y, id);
        dfs(grid, x-1, y, id);
        dfs(grid, x, y+1, id);
        dfs(grid, x, y-1, id);
    }
}
