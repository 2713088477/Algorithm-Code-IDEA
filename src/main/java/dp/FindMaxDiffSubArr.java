package dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindMaxDiffSubArr {
    private Map<Integer,Integer> cnt=new HashMap<>();
    public int longestSubsequence(int[] arr, int difference) {
        int len=arr.length;
        int maxLen=1;
        int curLen=0;
        for(int i=0;i<len;i++){
             curLen = cnt.getOrDefault(arr[i]-difference,0)+1;
             cnt.put(arr[i],curLen);
             maxLen=Math.max(maxLen,curLen);
        }
        return maxLen;
    }

}
