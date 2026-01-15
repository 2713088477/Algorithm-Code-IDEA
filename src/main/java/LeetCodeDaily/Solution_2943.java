package LeetCodeDaily;

import java.util.Arrays;

public class Solution_2943 {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int r = Math.min(f(hBars),f(vBars))+1;
        return r*r;
    }
    public int f(int[] nums){
        Arrays.sort(nums);
        int cnt=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1){
                cnt++;
                max=Math.max(max,cnt);
            }else{
                cnt=1;
            }
        }
        return max;
    }

}
