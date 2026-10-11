package ZuoVideo67;

//测试链接: https://leetcode.cn/problems/word-search/
public class Code02_Word_search {
    public boolean exist(char[][] board, String word) {
        char[] wordCharArray = word.toCharArray();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(f(board,i,j,wordCharArray,0)) return true;
            }
        }
        return false;
    }
    public static boolean f(char[][] board,int x,int y,char[] wordArray,int index){
        if(index == wordArray.length){
            return true;
        }
        if(x<0 || y<0 || x>=board.length || y>=board[0].length || board[x][y] != wordArray[index]){
            return false;
        }
        char tmp = board[x][y];
        board[x][y] = 0;//标记为访问过
        boolean ans = f(board,x+1,y,wordArray,index+1)
                || f(board,x,y+1,wordArray,index+1)
                || f(board,x-1,y,wordArray,index+1)
                || f(board,x,y-1,wordArray,index+1);
        board[x][y] = tmp;
        return ans;
    }
}
