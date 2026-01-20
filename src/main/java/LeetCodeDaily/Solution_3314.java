package LeetCodeDaily;

import java.util.List;

public class Solution_3314 {
    //11的二进制1011 13的二进制1101
    //11+1 ->  1010         1100
    //5 -> 101 100
    //从最右边开始，找到连续得一段1把他最左边变为0
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans=new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            for(int start=0;start<32;start++){
                if((num & (1<<start))!=0){
                    int end=start;
                    while(end < 32 && (num&(1<<end))!=0) end++;
                    end--;
                    if(end == start && end!=0){
                        ans[i]=-1;
                    }else{
                        ans[i]=num ^ (1<<end);
                    }
                }
            }
        }
        return ans;
    }
}
