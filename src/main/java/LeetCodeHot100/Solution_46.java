package LeetCodeHot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_46 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length];
        f(nums,arr,0);
        return ans;
    }
    public void f(int[] nums,int[] arr,int size){
        if(size == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                list.add(arr[i]);
            }
            ans.add(list);
            return;
        }
        for(int i=size;i<nums.length;){
            swap(nums,size,i);
            arr[size] = nums[size];
            f(nums,arr,size+1);
            swap(nums,size,i);//恢复现场
            int j=i+1;
            while(j<nums.length && nums[j]== nums[i]) j++;
            i=j;
        }

    }
    public void swap(int[] nums,int i,int j){
        if(i==j) return;
        nums[i]=nums[i]^nums[j];
        nums[j]=nums[i]^nums[j];
        nums[i]=nums[i]^nums[j];
    }
}
