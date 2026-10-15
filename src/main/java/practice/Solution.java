package practice;

import java.util.Arrays;

public class Solution {
    public static int MAX_SIZE = 100;
    public static int[] arr = new int[MAX_SIZE];

    public static void main(String[] args) {
        for(int i=0;i<MAX_SIZE;i++){
            arr[i] = (int)(Math.random()*(MAX_SIZE+1));
        }
        System.out.println("排序之前:");
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println("排序后:");
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int[] nums){
        quickSortByRange(nums,0,nums.length-1);
    }
    public static void quickSortByRange(int[] nums,int left,int right){
        if(left<right){
            random(nums,left,right);
            int stander = nums[left];
            int l=left,r=right;
            while(l<r){
                while(l<r && nums[r] >= stander){
                    r--;
                }
                swap(nums,l,r);
                while(l<r && nums[l] < stander){
                    l++;
                }
                swap(nums,l,r);
            }
            quickSortByRange(nums,left,r-1);
            quickSortByRange(nums,r+1,right);
        }
    }
    //将[left,right]中随机选出一位，与nums[left]交换
    public static void random(int[] nums,int left,int right){
        // [0,1) [left,right]->[0,right-left]
        int index = (int)(Math.random()*(right-left+1)) + left;
        swap(nums,index,left);
    }
    public static void swap(int[] nums,int left,int right){
        if(left == right) return;
        nums[left] = nums[left] ^ nums[right];
        nums[right] = nums[left] ^ nums[right];
        nums[left] = nums[left] ^ nums[right];
    }

}
