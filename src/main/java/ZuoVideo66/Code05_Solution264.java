package ZuoVideo66;

//测试链接: https://leetcode.cn/problems/ugly-number-ii/
public class Code05_Solution264 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1,p1=0,p2=0,p3=0;i<n;i++){
            int a = dp[p1] * 2,b = dp[p2] * 3,c = dp[p3] * 5;
            dp[i] = Math.min(Math.min(a,b),c);
            if(dp[i] == a) p1++;
            if(dp[i] == b) p2++;
            if(dp[i] == c) p3++;
        }
        return dp[n-1];
    }
}
