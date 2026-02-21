package ZuoVideo46;

import java.util.HashMap;
import java.util.Map;

//测试链接:https://leetcode.cn/problems/subarray-sum-equals-k/description/
public class Code03_Solution560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans =0;
        for(int i=0,sum=0;i< nums.length;i++){
            sum += nums[i];
            //sum-need = k need -> sum-k
            ans += map.getOrDefault(sum-k,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
