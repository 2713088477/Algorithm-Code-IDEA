package ZuoVideo51;

import java.util.Arrays;

//测试链接:https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
public class Code04_Solution719 {
    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int l = 0,r = nums[len-1]-nums[0];
        int mid =0;
        int ans = 0;
        while(l <= r){
            mid = l+ ((r-l)>>2);
            if(f(nums,mid) >= k){
                ans = mid;
                r= mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public static int f(int[] nums,int limit){
        int ans = 0;
        for(int l=0,r=0;l<nums.length;l++){
            while(r<nums.length &&  nums[r]-nums[l] <= limit){
                r++;
            }
            ans += r-l-1;
        }
        return ans;
    }

}
