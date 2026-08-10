package ZuoVideo66;

import java.util.Arrays;

//测试链接: https://leetcode.cn/problems/decode-ways/description/
public class Code03_Solution91 {
    //1.暴力递归
    public int numDecodings1(String s) {
        char[] charArray = s.toCharArray();
        return f1(charArray,0);
    }
    public int f1(char[] arr,int index){
        //递归终止条件
        if(index == arr.length){
            return 1;
        }
        int ans;
        if(arr[index]=='0'){
            ans = 0;
        }else{
            ans = f1(arr,index+1);
            if(index+1 < arr.length && (arr[index]-'0')*10 + (arr[index+1]-'0') <= 26 ){
                ans += f1(arr,index+2);
            }
        }
        return ans;
    }

    //2.记忆化搜索
    public int numDecodings2(String s) {
        char[] charArray = s.toCharArray();
        int[] dp = new int[charArray.length];
        Arrays.fill(dp,-1);
        return f2(charArray,0,dp);
    }
    public int f2(char[] arr,int index,int[] dp){
        //递归终止条件
        if(index == arr.length){
            return 1;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int ans;
        if(arr[index]=='0'){
            ans = 0;
        }else{
            ans = f2(arr,index+1,dp);
            if(index+1 < arr.length && (arr[index]-'0')*10 + (arr[index+1]-'0') <= 26 ){
                ans += f2(arr,index+2,dp);
            }
        }
        dp[index] = ans;
        return ans;
    }

    //3.从低到顶，严格位置依赖的动态规划
    public int numDecodings3(String s) {
        char[] charArray = s.toCharArray();
        int[] dp = new int[charArray.length+1];
        dp[charArray.length] = 1;
        for(int index = charArray.length-1;index>=0;index--){
            if(charArray[index] == '0'){
                dp[index] = 0;
            }else{
                dp[index] = dp[index+1];
                if(index + 1 < charArray.length && (charArray[index]-'0')*10 + (charArray[index+1]-'0') <= 26){
                    dp[index] += dp[index+2];
                }
            }
        }
        return dp[0];
    }

    //4.从低到顶，严格位置依赖的动态规划(滚动数组)
    public int numDecodings4(String s) {
        char[] charArray = s.toCharArray();
        int next = 1,nextnext = 0;
        int cur = 0;
        for(int index = charArray.length-1;index>=0;index--){
            if(charArray[index] == '0'){
                cur = 0;
            }else{
                cur = next;
                if(index + 1 < charArray.length && (charArray[index]-'0')*10 + (charArray[index+1]-'0') <= 26){
                    cur += nextnext;
                }
            }
            nextnext = next;
            next = cur;
        }
        return cur;
    }
}
