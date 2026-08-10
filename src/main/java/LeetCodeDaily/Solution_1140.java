package LeetCodeDaily;

import java.util.Arrays;

//测试链接: https://leetcode.cn/problems/stone-game-ii/description/?envType=daily-question&envId=2026-08-09
public class Solution_1140 {
    public static int[] sum;
    public static int stoneGameII(int[] piles) {
        build(piles);
        int total = getSubArrSumByRange(0,piles.length-1);
        //System.out.println(String.format("total = %d",total));
        int[][] dp = new int[piles.length][piles.length];
        for(int[] d:dp){
            Arrays.fill(d,Integer.MIN_VALUE);
        }
        int diff =  findDiffMax(piles.length,0,1,dp);
        //System.out.println(String.format("diff = %d",diff));
        return (total+diff)/2;
    }
    public static void build(int[] arr){
        sum = new int[arr.length+1];
        for(int i=1;i<=arr.length;i++){
            sum[i] = sum[i-1] + arr[i-1];
        }
    }
    public static int getSubArrSumByRange(int s,int e){
        return sum[e+1]-sum[s];
    }
    public static int findDiffMax(int len,int startIndex, int m,int[][] dp){
        //递归终止条件
        if(startIndex >= len){
            return 0;
        }
        if(dp[startIndex][m] != Integer.MIN_VALUE){
            return dp[startIndex][m];
        }
        //尝试拿
        int diff = Integer.MIN_VALUE;
        for(int count = 1,nextIndex;count<=2*m;count++){
            nextIndex = startIndex + count;
            if(nextIndex > len) break;
            diff = Math.max(diff,getSubArrSumByRange(startIndex,nextIndex-1)-findDiffMax(len,nextIndex,Math.max(count,m),dp));
        }
        dp[startIndex][m] = diff;
        return diff;
    }

    public static void main(String[] args) {
        int[] piles = new int[]{2,7,9,4,4};
        System.out.println(stoneGameII(piles));
    }

}
