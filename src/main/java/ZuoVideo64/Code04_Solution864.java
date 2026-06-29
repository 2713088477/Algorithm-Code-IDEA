package ZuoVideo64;

//测试链接:https://leetcode.cn/problems/shortest-path-to-get-all-keys/description/
public class Code04_Solution864 {
    public static int MAX_M = 30;
    public static int MAX_N = 30;
    public static int MAX_K = 6;
    public static boolean[][][] visit = new boolean[MAX_M][MAX_N][1<<MAX_K];
    public static int[][] deque = new int[MAX_M*MAX_N*(1<<MAX_K)][3];
    public static int l,r,row,col,key;
    public static char[][] arr = new char[MAX_N][MAX_N];
    public static int[] direction = new int[]{1,0,-1,0,1};
    public int shortestPathAllKeys(String[] grid) {
        build(grid);
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]=='@'){
                    push(i,j,0);
                    break;
                }
            }
        }
        int level = 1;
        while(!isEmpty()){
            int loopSize = r-l;
            for(int loop = 0;loop < loopSize;loop++){
                int[] poll = poll();
                int x = poll[0],y = poll[1],status=poll[2];
                for(int i=0,nx,ny,ns;i<4;i++){
                    nx = x + direction[i];
                    ny = y + direction[i+1];
                    ns = status;
                    if(nx<0 || nx>=row || ny<0 || ny>=col || arr[nx][ny] == '#'){
                        continue;
                    }
                    if(arr[nx][ny]>='A' && arr[nx][ny]<='F' && (ns&(1<<(arr[nx][ny]-'A')))==0){
                        continue;
                    }
                    if(arr[nx][ny]>='a' && arr[nx][ny]<='f'){
                        ns |= 1<<(arr[nx][ny]-'a');
                    }
                    if(ns == key){
                        return level;
                    }
                    if(!visit[nx][ny][ns]){
                        push(nx,ny,ns);
                    }
                }
            }

            level++;
        }
        return -1;

    }
    public static void build(String[] grid){
        row = grid.length;
        col = grid[0].length();
        for(int i=0;i<row;i++){
            arr[i] = grid[i].toCharArray();
        }
        key = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(arr[i][j]>='a' && arr[i][j]<='f'){
                    key |= 1<<(arr[i][j]-'a');
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                for(int k=0;k<=key;k++){
                    visit[i][j][k] = false;
                }
            }
        }
        l=r=0;
    }
    public static boolean isEmpty(){
        return l==r;
    }
    public static int[] poll(){
        return deque[l++];
    }
    public static void push(int x,int y,int status){
        visit[x][y][status] = true;
        deque[r][0] = x;
        deque[r][1] = y;
        deque[r++][2] = status;
    }
}
