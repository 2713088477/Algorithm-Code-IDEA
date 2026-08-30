package ZuoVideo66;

//测试链接: https://leetcode.cn/problems/longest-valid-parentheses/description/
public class Code06_Solution32 {
    public static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        int ans = 0;
        for(int i=1;i<dp.length;i++){
            int e = i-1-dp[i-1];
            if(e>=0 && chars[i] ==')' && chars[e] == '('){
                dp[i] = 2 + dp[i-1] + (e-1 >= 0 ? dp[e-1] : 0);
            }else{
                dp[i] = 0;
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses(s));
    }
}
