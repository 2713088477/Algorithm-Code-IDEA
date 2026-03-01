package ZuoVideo48;

//测试链接:https://leetcode.cn/problems/largest-1-bordered-square/
public class Code02_Solution1139 {

    //暴力破解
    public int largest1BorderedSquare(int[][] grid) {
        int xlen = grid.length;
        int ylen = grid[0].length;
        int ans =0;
        for(int i=0;i<xlen;i++){
            for(int j=0;j<ylen;j++){
                for(int nx = i+ans,ny=j+ans;nx<xlen&&ny<ylen;nx++,ny++){
                    if(check(grid,i,j,nx,ny)){
                        ans = nx-i+1;
                    }
                }
            }
        }
        return ans*ans;
    }
    public static boolean check(int[][] arr,int x,int y,int nx,int ny){
        if(nx == x) return arr[x][y]==1;
        for(int i=x;i<=nx;i++){
            if(arr[i][y]==0 ||arr[i][ny]==0) return false;
        }
        for(int j=y;j<=ny;j++){
            if(arr[x][j]==0 ||arr[nx][j]==0) return false;
        }
        return true;
    }

}
