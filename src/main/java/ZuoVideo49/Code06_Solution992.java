package ZuoVideo49;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/subarrays-with-k-different-integers/
public class Code06_Solution992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return countLessThanK(nums,k)-countLessThanK(nums,k-1);
    }
    public static int MAX_SIZE = 20001;
    public static int[] cnt = new int[MAX_SIZE];
    public static int countLessThanK(int[] nums,int k){
        Arrays.fill(cnt,0);
        int ans =0;
        for(int r=0,l=0,collect=0;r<nums.length;r++){
            if(cnt[nums[r]]++==0){
                collect++;
            }
            while (collect>k){
                if(--cnt[nums[l++]] == 0){
                    collect--;
                }
            }
            ans +=(r-l+1);
        }
        return ans;
    }
}
