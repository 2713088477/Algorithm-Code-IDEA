package LeetCodeDaily;

//测试链接: https://leetcode.cn/problems/stone-game-ii/description/?envType=daily-question&envId=2026-08-09
//todo(没有解决)
public class Solution_1140 {
    public static int[] sum;
    public int stoneGameII(int[] piles) {
        build(piles);
        return findAliceMax(0,1);
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
    public int findAliceMax(int startIndex,int m){
        //递归终止条件

        //尝试拿
        int ans = Integer.MIN_VALUE;
        for(int count = 1,nextIndex;count<=2*m;count++){
            nextIndex = startIndex + count;
            ans = getSubArrSumByRange(startIndex,nextIndex-1) + findAliceMax(nextIndex,Math.max(m,count));
        }

        return 0;
    }
}
