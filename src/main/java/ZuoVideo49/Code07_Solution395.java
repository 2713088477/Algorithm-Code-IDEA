package ZuoVideo49;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/description/
public class Code07_Solution395 {
    public static int[] cnt = new int[256];
    public int longestSubstring(String s, int k) {
        int ans = 0;
        char[] array = s.toCharArray();
        for (int require = 1; require<=26;require++) {
            Arrays.fill(cnt,0);
            for(int r=0,l=0,collect=0,satisfy=0;r<array.length;r++){
                cnt[array[r]]++;
                if(cnt[array[r]] == k){
                    satisfy++;
                }
                if(cnt[array[r]] == 1){
                    collect++;
                }
                while(collect > require){
                    if(cnt[array[l]] == k){
                        satisfy--;
                    }
                    if(cnt[array[l]]==1){
                        collect--;
                    }
                    cnt[array[l++]]--;
                }
                if(satisfy == require){
                    ans = Math.max(ans,r-l+1);
                }
            }
        }
        return ans;
    }
}
