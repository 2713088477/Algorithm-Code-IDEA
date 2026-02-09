package simulate;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution_3834 {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> ans = new ArrayList<>();
        for(int i=0;i< nums.length;i++){
            long cur=nums[i];
            ans.add(cur);
            while(ans.size()>=2 && ans.get(ans.size()-1).equals(ans.get(ans.size()-2))){
                ans.set(ans.size()-2,ans.get(ans.size()-2)*2);
                ans.remove(ans.size()-1);
            }
        }
        return ans;
    }
}
