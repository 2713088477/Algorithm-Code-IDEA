package dfs;

public class NQueens_52 {
    //经典版递归
    public int totalNQueens1(int n) {
        int[] path = new int[n];
        return f1(0,path,n);
    }
    public int f1(int curRow,int[] path,int n){
        if(curRow == n){
            return 1;
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            path[curRow]=i;
            if(check(path,curRow,i)){
                ans += f1(curRow+1,path,n);
            }
        }
        return ans;
    }
    private boolean check(int[] path, int curRow, int curCol) {
        for(int i=0;i<curRow;i++){
            if(path[i]==curCol || Math.abs(curRow-i)==Math.abs(curCol-path[i])){
                return false;
            }
        }
        return true;
    }

    //用位运算实现递归版本
    public int totalNQueens2(int n) {
        int limit = (1<<n) -1;
        return f2(limit,0,0,0);
    }
    public int f2(int limit,int col,int left,int right){
        if(col == limit){
            return 1;
        }
        int cadidate = col | left | right;
        cadidate = ((~cadidate) & limit);
        int ans = 0;
        while(cadidate != 0){
            int choice = cadidate & (~cadidate+1);
            cadidate ^= choice;
            ans += f2(limit,col | choice,(left | choice)<<1 ,(right | choice) >>1);
        }
        return ans;
    }
}
