package ZuoVideo56;


//测试链接:https://leetcode.cn/problems/number-of-islands/description/
public class Code05_Solution200 {
    public static int MAX_SIZE = 90000;
    public static int[] father = new int[MAX_SIZE];
    public static int cnt;
    public static int row,col;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        build(grid);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    if(i-1>=0 && grid[i-1][j]=='1'){
                        union(getIndexOfGrid(i, j), getIndexOfGrid(i-1, j));
                    }
                    if(j-1>=0 && grid[i][j-1]=='1'){
                        union(getIndexOfGrid(i, j),getIndexOfGrid(i, j-1));
                    }
                }
            }
        }
        return cnt;
    }
    public static void build(char[][] grid){
        cnt = 0;
        int index=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    index = getIndexOfGrid(i, j);
                    father[index] = index;

                }
            }
        }
    }
    public static int getIndexOfGrid(int x,int y){
        return x*col+y;
    }
    public static int find(int cur){
        if(cur == father[cur]){
            return cur;
        }
        father[cur] = find(father[cur]);
        return father[cur];
    }
    public static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb){
            father[fa] = fb;
            cnt--;
        }
    }
    
    
}
