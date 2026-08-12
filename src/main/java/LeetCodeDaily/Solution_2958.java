package LeetCodeDaily;

import java.util.HashMap;
import java.util.Map;

//测试链接: https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/description/?envType=daily-question&envId=2026-08-12
public class Solution_2958 {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        int ans = 1;
        int left = 0;
        for(int right = 0;right<nums.length;right++){
            while(count.getOrDefault(nums[right],0) >= k){
                count.put(nums[left],count.get(nums[left])-1);
                left++;
            }
            count.put(nums[right], count.getOrDefault(nums[right],0)+1);
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
