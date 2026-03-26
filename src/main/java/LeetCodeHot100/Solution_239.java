package LeetCodeHot100;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import static java.lang.Math.max;

public class Solution_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int index=0;
        NavigableMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            if(i-k+1<0){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
                continue;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            ans[index++] = map.lastKey();
            if(map.get(nums[i-k+1])==1){
                map.remove(nums[i-k+1]);
            }else {
                map.put(nums[i-k+1],map.get(nums[i-k+1])-1);
            }

        }
        return ans;

    }
}
