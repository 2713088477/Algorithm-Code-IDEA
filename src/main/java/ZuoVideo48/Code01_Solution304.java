package ZuoVideo48;

//测试链接:https://leetcode.cn/problems/range-sum-query-2d-immutable/description/
public class Code01_Solution304 {
    public int[][] sum;
    public Code01_Solution304(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row+1][col+1];
        for(int a=0,c=1;a<row;a++,c++){
            for(int b=0,d=1;b<col;b++,d++){
                sum[c][d]=matrix[a][b];
            }
        }
        for(int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                sum[i][j]+=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
            }
        }
    }
    public int sumRegion(int a, int b, int c, int d) {
        c++;d++;
        return sum[c][d]-sum[c][b]-sum[a][d]+sum[a][b];
    }
}
