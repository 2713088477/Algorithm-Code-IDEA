package LeetCodeDaily;

import java.util.Arrays;

public class Solution_2090 {
    public static int[] cnt = new int[26];
    public int maximumLengthSubstring(String s) {
        Arrays.fill(cnt,0);
        int maxLen = 1;
        int left = 0;
        for(int right = 0;right < s.length();right++){
            int index = getIndexOfChar(s.charAt(right));
            cnt[index]++;
            while(cnt[index] > 2){
                cnt[getIndexOfChar(s.charAt(left++))]--;
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
    public static int getIndexOfChar(char x){
        return x-'a';
    }
}
