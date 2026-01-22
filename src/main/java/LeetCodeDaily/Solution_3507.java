package LeetCodeDaily;

import java.util.ArrayList;
import java.util.List;

public class Solution_3507 {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
        int ans=0;
        while(!isOk(list)){
            solve(list);
            ans++;
        }
        return ans;
    }
    private void solve(List<Integer> list) {
        int sum = list.get(0)+list.get(1);
        int minIndex1=0;
        for(int i=0;i+1<list.size();i++){
            int t = list.get(i)+list.get(i+1);
            if(t<sum){
                sum=t;
                minIndex1=i;
            }
        }
        list.set(minIndex1,sum);
        list.remove(minIndex1+1);
    }

    private boolean isOk(List<Integer> list) {
        for(int i=0;i+1<list.size();i++){
            if(list.get(i)>list.get(i+1)) return false;
        }
        return true;
    }
}
