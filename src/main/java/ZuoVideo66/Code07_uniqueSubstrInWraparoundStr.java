package ZuoVideo66;

//测试链接: https://leetcode.cn/problems/unique-substrings-in-wraparound-string/description/
public class Code07_uniqueSubstrInWraparoundStr {
    public int findSubstringInWraproundString(String s) {
        int[] arr = new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i)-'a';
        }
        int[] dp = new int[26];
        dp[arr[0]] = 1;
        for(int r=1,len=1;r<arr.length;r++){
            int cur = arr[r];
            int pre = arr[r-1];
            if(pre==25 && cur == 0 || pre+1 == cur){
                len++;
            }else{
                len=1;
            }
            dp[cur] = Math.max(dp[cur],len);
        }
        int ans = 0;
        for(int num:dp){
            ans += num;
        }
        return ans;
    }
}
