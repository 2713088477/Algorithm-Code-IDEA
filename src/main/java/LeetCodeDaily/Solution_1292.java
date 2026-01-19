package LeetCodeDaily;

public class Solution_1292 {
    private int[][] prefix= null;
    public void init(int[][] mat){
        int m =mat.length,n=mat[0].length;
        prefix = new int[m][n];
        prefix[0][0]=mat[0][0];
        for(int i=1;i<n;i++){
            prefix[0][i]=prefix[0][i-1]+mat[0][i];
        }
        for(int i=1;i<m;i++){
            prefix[i][0]=prefix[i-1][0]+mat[i][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                prefix[i][j]=prefix[i-1][j]+prefix[i][j-1]+mat[i][j]-prefix[i-1][j-1];
            }
        }
    }
    public int getSum(int x,int y){
        return prefix[x][y];
    }
    public int getSum(int sx,int sy,int ex,int ey){
        return prefix[ex][ey]-(sx-1>=0?prefix[sx-1][ey]:0)-(sy-1>=0?prefix[ex][sy-1]:0)+((sx-1>=0&&sy-1>=0)?prefix[sx-1][sy-1]:0);
    }
    public int maxSideLength(int[][] mat, int threshold) {
        int m=mat.length,n=mat[0].length;
        init(mat);
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]<=threshold){
                    ans=Math.max(ans,1);
                    int maxR=Math.min(m-i,n-j);
                    for (int r=maxR;r>=2;r--){
                        if(isOk(mat,i,j,r,threshold)){
                            ans=Math.max(ans,r);
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }
    public boolean isOk(int[][] mat,int x,int y,int r,int threshold){
        return getSum(x,y,x+r-1,y+r-1)<=threshold;
    }
}
