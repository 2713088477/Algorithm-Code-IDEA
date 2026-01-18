package LeetCodeDaily;

import java.util.Arrays;

public class Solution_1895 {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int ans = 1;
        //暴力枚举
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int kmax=Math.min(m-i,n-j);
                for(int k=kmax;k>0;k--){
                    if(isOk(grid,i,j,k)){
                        ans=Math.max(ans,k);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private boolean isOk(int[][] grid, int x, int y, int k) {
        if(k==1) return true;
        int target =0;
        for(int i = x;i<x+k;i++){
            target+=grid[i][y];
        }
        //判断每一行是否相等
        for(int i=x;i<x+k;i++){
            int sum=0;
            for(int j=y;j<y+k;j++){
                sum+=grid[i][j];
            }
            if(sum!=target) return false;
        }
        //判断每一列是否相等
        for(int j=y;j<y+k;j++){
            int sum=0;
            for(int i=x;i<x+k;i++){
                sum+=grid[i][j];
            }
            if(sum!=target) return false;
        }
        //判断对角线是否相等
        int sum=0;
        for(int i=x,j=y;i<x+k&&j<y+k;i++,j++){
            sum+=grid[i][j];
        }
        if(sum!=target) return false;
        sum=0;
        for(int i=x,j=y+k-1;i<x+k&&j>=y;i++,j--){
            sum+=grid[i][j];
        }
        if(sum!=target) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,9,3,5,5,8,1,6,9},{4,1,1,6,8,3,5,7,6},{9,8,4,7,2,4,9,2,7},{1,9,8,10,5,10,1,6,3}};
        for(int[] t:grid){
            System.out.println(Arrays.toString(t));
        }
        System.out.println(new Solution_1895().largestMagicSquare(grid));
    }
}
