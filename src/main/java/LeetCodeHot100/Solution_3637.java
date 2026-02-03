package LeetCodeHot100;

public class Solution_3637 {
    public boolean isTrionic(int[] nums) {
        int i1=0;
        while(i1+1<nums.length && nums[i1+1]>nums[i1]) i1++;
        if(i1+1 == nums.length || i1 ==0) return false;
        int i2=i1;
        while(i2+1<nums.length && nums[i2+1]<nums[i2]) i2++;
        if(i2+1==nums.length || i2==i1) return false;
        int i3=i2;
        while(i3+1<nums.length && nums[i3+1]>nums[i3]) i3++;
        return i3==nums.length-1;
    }
}
