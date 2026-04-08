package LeetCodeHot100;


import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/maximum-subarray/?envType=study-plan-v2&envId=top-100-liked
public class Solution_53 {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for(int i=0,curSum=0;i<nums.length;i++){
            curSum += nums[i];
            ans = Math.max(ans,curSum);
            if(curSum < 0){
                curSum = 0;
            }
        }
        return ans;
    }

}
