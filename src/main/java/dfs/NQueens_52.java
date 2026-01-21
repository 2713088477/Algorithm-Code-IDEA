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
}
