package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution_78 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int[] arr=new int[nums.length];
        f(nums,0,arr,0);
        return ans;
    }
    public void f(int[] nums,int index,int[] arr,int size){
        if(index==nums.length){
            if(size==0){
                ans.add(Collections.emptyList());
            }else{
                List<Integer> t =new ArrayList<>();
                for(int i=0;i<size;i++){
                    t.add(arr[i]);
                }
                ans.add(t);
            }
            return;
        }
        f(nums,index+1,arr,size);
        arr[size]=nums[index];
        f(nums,index+1,arr,size+1);
    }
}
