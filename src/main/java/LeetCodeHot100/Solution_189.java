package LeetCodeHot100;

//测试链接:https://leetcode.cn/problems/rotate-array/submissions/717848129/?envType=study-plan-v2&envId=top-100-liked
public class Solution_189 {
    public void rotate(int[] nums, int k) {
        k%=nums.length;
        int theIndex = nums.length-k-1;
        reverse(nums,0,theIndex);
        reverse(nums,theIndex+1,nums.length-1);
        reverse(nums,0, nums.length-1);
    }
    public static void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start++,end--);
        }
    }
    public static void swap(int[] nums,int a,int b){
        if(a==b) return;
        nums[a] = nums[a] ^ nums[b];
        nums[b] = nums[a] ^ nums[b];
        nums[a] = nums[a] ^ nums[b];
    }
}
