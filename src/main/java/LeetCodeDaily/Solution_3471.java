package LeetCodeDaily;

import java.util.Arrays;

//测试链接: https://leetcode.cn/problems/find-the-largest-almost-missing-integer/?envType=daily-question&envId=2026-08-18
public class Solution_3471 {
    public int largestInteger(int[] nums, int k) {
        if(k==1){
            Arrays.sort(nums);
            for(int i=nums.length-1;i>=0;i--){
                if(isNonDuplicate(nums,i)){
                    return nums[i];
                }
            }
        }
        if(k == nums.length){
            return Arrays.stream(nums).max().getAsInt();
        }
        int ans = -1;
        if (isNonDuplicate(nums,0)){
            ans = Math.max(ans,nums[0]);
        }
        if (isNonDuplicate(nums,nums.length-1)){
            ans = Math.max(ans,nums[nums.length-1]);
        }
        return ans;


    }
    public boolean isNonDuplicate(int[] nums,int index){
        for(int i=0;i<nums.length;i++){
            if(nums[i] == nums[index] && index!=i) return false;
        }
        return true;
    }
}
