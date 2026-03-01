package ZuoVideo48;

//测试链接:https://leetcode.cn/problems/largest-1-bordered-square/
public class Code02_Solution1139_better {

    //前缀和方法破解
    public int largest1BorderedSquare(int[][] grid) {
        int xlen = grid.length;
        int ylen = grid[0].length;
        build(grid);
        //如果整体和为0，说明一定不存在为1的点
        if(sum(grid,0,0,xlen-1,ylen-1)==0){
            return 0;
        }
        int ans =1;
        for(int i=0;i<xlen;i++){
            for(int j=0;j<ylen;j++){
                for(int nx = i+ans,ny=j+ans;nx<xlen&&ny<ylen;nx++,ny++){
                    if(check(grid,i,j,nx,ny)){
                        ans = nx -i+1;
                    }
                }
            }
        }
        return ans*ans;
    }
    public static boolean check(int[][] g,int x,int y,int nx,int ny){
        if(nx==x+1){
            return sum(g,x,y,nx,ny)==4;
        }
        //计算最外层的周长
        return sum(g,x,y,nx,ny)-sum(g,x+1,y+1,nx-1,ny-1) == ((nx-x)<<2);
    }
    public static void build(int[][] g){
        for (int x = 0; x < g.length; x++) {
            for (int y = 0; y < g[0].length; y++) {
                g[x][y] += get(g,x-1,y)+get(g,x,y-1)-get(g,x-1,y-1);
            }
        }
    }
    public static int get(int[][] g,int x,int y){
        return x<0||y<0?0:g[x][y];
    }
    public static int sum(int[][] g,int lx,int ly,int rx,int ry){
        return get(g,rx,ry)-get(g,rx,ly-1)-get(g,lx-1,ry)+get(g,lx-1,ly-1);
    }


}
