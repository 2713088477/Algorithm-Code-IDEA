package LeetCodeHot100;

import java.util.Arrays;

public class Solution_42 {

    public int trap(int[] height) {
        int len = height.length;
        int[] left = new int[len];
        left[0]=height[0];
        int[] right = new int[len];
        right[len-1]=height[len-1];
        for(int i=1;i<len;i++){
            left[i]=Math.max(left[i-1],height[i-1]);
        }
        for(int i=len-2;i>=0;i--){
            right[i]=Math.max(right[i+1],height[i]);
        }
        int ans =0;
        for(int i=0;i<len;i++){
            if(Math.min(left[i],right[i])-height[i] >0){
                ans += Math.min(left[i],right[i])-height[i];
            }
        }
        return ans;
    }
}
