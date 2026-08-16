package ZuoVideo66;

import java.util.Arrays;

//测试链接: https://leetcode.cn/problems/decode-ways-ii/description/
public class Code04_DecodeII {
    private long mod = (long) 1e9+7L;

    //暴力递归尝试
    public int numDecodings1(String s) {
        return f1(s,0);
    }
    public int f1(String s,int index){
        if(index == s.length()){
            return 1;
        }
        if(s.charAt(index)=='0') return 0;
        int ans = f1(s,index+1) * (s.charAt(index)=='*'?9:1);
        if(index+1 >= s.length()) return ans;
        if(s.charAt(index) != '*'){
            if(s.charAt(index+1) != '*'){
                if((s.charAt(index)-'0')*10 + (s.charAt(index+1)-'0') <= 26){
                    ans += f1(s,index+2);
                }
            }else{
                ans += (s.charAt(index) <='2' ? (s.charAt(index) == '1'? 9:6 ): 0)*f1(s,index+2);
            }
        }else{
            if(s.charAt(index+1) != '*'){
                ans += (s.charAt(index+1) <= '6'? 2 : 1)*f1(s,index+2);
            }else{
                ans += 15*f1(s,index+2);
            }
        }
        return ans;
    }

    //挂缓存表
    public int numDecodings2(String s) {
        long[] dp = new long[s.length()+1];
        Arrays.fill(dp,-1L);
        return (int)f2(s,0,dp);
    }
    public long f2(String s,int index,long[] dp){
        if(index == s.length()){
            return 1;
        }
        if(dp[index] != -1L){
            return dp[index];
        }
        if(s.charAt(index)=='0') return 0;
        long ans = f2(s,index+1,dp) * (s.charAt(index)=='*'?9:1);
        if(index+1 >= s.length()) return ans;
        if(s.charAt(index) != '*'){
            if(s.charAt(index+1) != '*'){
                if((s.charAt(index)-'0')*10 + (s.charAt(index+1)-'0') <= 26){
                    ans += f2(s,index+2,dp);
                }
            }else{
                ans += (s.charAt(index) <='2' ? (s.charAt(index) == '1'? 9:6 ): 0)*f2(s,index+2,dp);
            }
        }else{
            if(s.charAt(index+1) != '*'){
                ans += (s.charAt(index+1) <= '6'? 2 : 1)*f2(s,index+2,dp);
            }else{
                ans += 15*f2(s,index+2,dp);
            }
        }
        dp[index] = ans%mod;
        return dp[index];
    }

    //严格位置依赖的动态规划
    public int numDecodings3(String s) {
        long[] dp = new long[s.length()+1];
        dp[s.length()] = 1;
        for(int index = s.length()-1;index>=0;index--){
            if(s.charAt(index)=='0'){
                dp[index] = 0L;
                continue;
            }
            dp[index] = dp[index+1] * (s.charAt(index)=='*'?9:1);
            if(index+1 >= s.length()) continue;
            if(s.charAt(index) != '*'){
                if(s.charAt(index+1) != '*'){
                    if((s.charAt(index)-'0')*10 + (s.charAt(index+1)-'0') <= 26){
                        dp[index] += dp[index+2];
                    }
                }else{
                    dp[index] += (s.charAt(index) <='2' ? (s.charAt(index) == '1'? 9:6 ): 0)*dp[index+2];
                }
            }else{
                if(s.charAt(index+1) != '*'){
                    dp[index] += (s.charAt(index+1) <= '6'? 2 : 1)*dp[index+2];
                }else{
                    dp[index] += 15*dp[index+2];
                }
            }
            dp[index] %= mod;
        }
        return (int)dp[0];
    }

    //严格位置依赖的动态规划+滚动更新
    public int numDecodings4(String s) {
        long next = 1L,nextnext = 0L;
        long cur = 0L;
        for(int index = s.length()-1;index>=0;index--){
            if(s.charAt(index)=='0'){
                cur = 0L;
                nextnext = next;
                next = cur;
                continue;
            }
            cur = next * (s.charAt(index)=='*'?9:1);
            if(index+1 >= s.length()){
                nextnext = next;
                next = cur;
                continue;
            }
            if(s.charAt(index) != '*'){
                if(s.charAt(index+1) != '*'){
                    if((s.charAt(index)-'0')*10 + (s.charAt(index+1)-'0') <= 26){
                        cur += nextnext;
                    }
                }else{
                    cur += (s.charAt(index) <='2' ? (s.charAt(index) == '1'? 9:6 ): 0)*nextnext;
                }
            }else{
                if(s.charAt(index+1) != '*'){
                    cur += (s.charAt(index+1) <= '6'? 2 : 1)*nextnext;
                }else{
                    cur += 15*nextnext;
                }
            }
            cur %= mod;
            nextnext = next;
            next = cur;
        }
        return (int)cur;
    }
}
