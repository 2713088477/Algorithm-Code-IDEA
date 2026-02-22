package ZuoVideo46;

import java.util.HashMap;
import java.util.Map;

//测试链接:https://leetcode.cn/problems/longest-well-performing-interval/
public class Code05_Solution1124 {
    public int longestWPI(int[] hours) {
        Map<Integer,Integer> prefix = new HashMap<>();
        prefix.put(0,-1);
        int ans = 0;
        for (int i = 0,sum=0; i < hours.length; i++) {
            sum += (hours[i]>8?1:-1);
            if(sum>0){
                ans = i+1;
            }else{
                //need=sum-1
                if(prefix.containsKey(sum-1)){
                    ans = Math.max(ans,i- prefix.get(sum-1));
                }
                prefix.putIfAbsent(sum,i);
            }
        }
        return ans;
    }
}
