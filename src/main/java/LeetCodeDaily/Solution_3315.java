package LeetCodeDaily;

import java.util.List;

public class Solution_3315 {
    public int[] minBitwiseArray(List<Integer> nums) {
        int len = nums.size();
        int[] arr=new int[len];
        for (int i = 0; i < len; i++) {
            int num =nums.get(i);
            if((num & (1)) == 0){
                arr[i]=-1;
                continue;
            }
            int end=0;
            while(end<32 && (num &(1<<end)) !=0) end++;
            end--;
            arr[i] = num & (~(1<<end));
        }
        return arr;
    }
}
