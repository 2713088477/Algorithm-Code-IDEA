package LeetCodeHot100;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
public class Solution_128 {
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        int ans = 1;
        for(int start=0,end,need;start<nums.length;){
            end = start+1;
            need = nums[start]+1;
            while (end < nums.length){
                if(nums[end]<need) end++;
                else if(nums[end]==need){
                    need++;
                    end++;
                }else{
                    break;
                }
            }
            ans = Math.max(ans,need-nums[start]);
            start = end;
        }
        return ans;

    }
}
