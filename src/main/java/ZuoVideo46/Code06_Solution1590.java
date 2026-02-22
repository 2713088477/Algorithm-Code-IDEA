package ZuoVideo46;

import java.util.HashMap;
import java.util.Map;

//测试链接:https://leetcode.cn/problems/make-sum-divisible-by-p/
public class Code06_Solution1590 {
    public int minSubarray(int[] nums, int p) {
        int sum =0;
        for(int num:nums){
            sum = (sum+num)%p;
        }
        if(sum == 0) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int ans = nums.length;
        for (int i = 0,cur=0; i < nums.length; i++) {
            cur = (cur+nums[i])%p;
            //(cur-need+p)%p==sum
            //need = (cur-sum+p)%p
            if(map.containsKey((cur-sum+p)%p)){
                ans = Math.min(ans,i-map.get((cur-sum+p)%p));
            }
            map.put(cur,i);
        }
        return ans == nums.length?-1:ans;
    }
}
