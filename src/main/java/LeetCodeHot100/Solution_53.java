package LeetCodeHot100;

import javax.print.DocFlavor;

//TODO
public class Solution_53 {
    public int maxSubArray(int[] nums) {
        int[] prefix = new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            prefix[i+1]=prefix[i]+nums[i];
        }
        return 0;
    }
}
