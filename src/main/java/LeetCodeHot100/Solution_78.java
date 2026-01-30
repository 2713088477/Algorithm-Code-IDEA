package LeetCodeHot100;

import java.util.ArrayList;
import java.util.List;

public class Solution_78 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int[] arr = new int[nums.length];
        f(nums,0,arr,0);
        return ans;
    }
    public void f(int[] nums,int cur,int[] arr,int size){
        if(cur == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++)list.add(arr[i]);
            ans.add(list);
            return;
        }
        f(nums,cur+1,arr,size);
        arr[size]=nums[cur];
        f(nums,cur+1,arr,size+1);
    }
}
