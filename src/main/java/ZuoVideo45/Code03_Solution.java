package ZuoVideo45;

import java.util.HashSet;
import java.util.Set;
//测试链接:https://leetcode.cn/problems/maximum-xor-of-two-numbers-in-an-array/description/
public class Code03_Solution {
    public static int high;
    public int findMaximumXOR(int[] nums) {
        int val = Integer.MIN_VALUE;
        for(int num:nums){
            val = Math.max(val,num);
        }
        high = 31 - Integer.numberOfLeadingZeros(val);
        int ans =0;
        Set<Integer> set = new HashSet<>();
        for(int i=high;i>=0;i--){
            int better = ans | (1<<i);
            set.clear();
            for (int num : nums) {
                num = (num>>i)<<i;
                set.add(num);
                //num^x=better -> x=better^num
                if(set.contains(better^num)){
                    ans = better;
                    break;
                }
            }
        }
        return ans;
    }
}
