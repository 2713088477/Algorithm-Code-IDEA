package LeetCodeDaily;

import java.util.HashSet;
import java.util.Set;

//测试链接: https://leetcode.cn/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/?envType=daily-question&envId=2026-08-11
public class Solution_2996 {
    public int missingInteger(int[] nums) {
        int maxLen = 1,maxSum = nums[0];
        Set<Integer> have = new HashSet<>();
        for(int num:nums){
            have.add(num);
        }
        int curCnt = 1,curSum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == nums[i-1]+1){
                curCnt++;
                curSum += nums[i];
            }else{
                if(curCnt>maxLen){
                    maxLen = curCnt;
                    maxSum = curSum;
                }
                curCnt = 1;
                curSum = nums[i];
                break;
            }
        }
        if(curCnt>maxLen){
            maxLen = curCnt;
            maxSum = curSum;
        }
        for(int i=maxSum;i<Integer.MAX_VALUE;i++){
            if(!have.contains(i)) return i;
        }
        return -1;
    }
}
