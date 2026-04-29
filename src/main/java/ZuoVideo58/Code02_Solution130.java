package ZuoVideo58;

//测试链接:https://leetcode.cn/problems/surrounded-regions/description/
public class Code02_Solution130 {
    public void solve(char[][] board) {
        int row = board.length,col = board[0].length;
        for(int i=0;i<col;i++){
            if(board[0][i]=='O'){
                dfs(board,0,i);
            }
            if(board[row-1][i]=='O'){
                dfs(board, row-1, i);
            }
        }
        for(int i=1;i<row-1;i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0);
            }
            if(board[i][col-1]=='O'){
                dfs(board, i, col-1);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='Y'){
                    board[i][j]='O';
                }
            }
        }
    }
    public static void dfs(char[][] board,int x,int y){
        if(x<0 || x>=board.length || y<0 || y>=board[0].length || board[x][y]!='O') return;
        board[x][y] = 'Y';
        dfs(board, x+1, y);
        dfs(board, x-1, y);
        dfs(board, x, y+1);
        dfs(board, x, y-1);
    }
}
