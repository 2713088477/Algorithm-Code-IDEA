package Bit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_78 {
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int len=nums.length;
        for(int i=0;i<(1<<len);i++){
            List<Integer> t = new ArrayList<>();
            for(int j=0;j<len;j++){
                if((i & (1<<j))!=0){
                    t.add(nums[j]);
                }
            }
            ans.add(t);
        }
        return ans;
    }

}
