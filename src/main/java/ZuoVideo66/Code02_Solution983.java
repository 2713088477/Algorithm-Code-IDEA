package ZuoVideo66;

import java.util.Arrays;

//测试链接: https://leetcode.cn/problems/minimum-cost-for-tickets/
public class Code02_Solution983 {
    private static int[] duration = new int[]{1,7,30};

    public int mincostTickets1(int[] days, int[] costs) {
        return f1(days,costs,0);
    }
    //1.暴力递归
    public static int f1(int[] days,int[] costs,int index){
        if(index == days.length){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0,j=index;i<3;i++){
            while(j<days.length && days[index] + duration[i] > days[j]){
                j++;
            }
            ans = Math.min(ans,costs[i] + f1(days,costs,j));
        }
        return ans;
    }

    public int mincostTickets2(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        return f2(days,costs,0,dp);
    }
    //2.记忆化搜搜
    public int f2(int[] days,int[] costs,int index,int[] dp){
        if(index == days.length){
            return 0;
        }
        if(dp[index]!=Integer.MAX_VALUE){
            return dp[index];
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0,j=index;i<3;i++){
            while(j<days.length && days[index] + duration[i] > days[j]){
                j++;
            }
            ans = Math.min(ans,costs[i] + f2(days,costs,j,dp));
        }
        dp[index] = ans;
        return ans;
    }

    //3.从底到顶的动态规划
    public int mincostTickets3(int[] days, int[] costs) {
        int len = days.length;
        int[] dp = new int[len+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[len] = 0;
        for(int index = len -1;index>=0;index--){
            for(int attempt = 0,nextIndex = index;attempt<costs.length;attempt++){
                while (nextIndex<len && days[index] + duration[attempt] > days[nextIndex]){
                    nextIndex++;
                }
                dp[index] = Math.min(dp[index],costs[attempt] + dp[nextIndex]);
            }
        }
        return dp[0];
    }




}
