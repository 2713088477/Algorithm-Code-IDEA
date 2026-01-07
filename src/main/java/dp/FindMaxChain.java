package dp;

import java.util.Arrays;
import java.util.OptionalInt;

public class FindMaxChain {
    public int findLongestChain(int[][] pairs) {
        //1.先按照第二个数排序，相同的话再按照第一个排序
        Arrays.sort(pairs,(p1,p2)->{
            if(p1[0]!=p2[0]){
                return Integer.compare(p1[0], p2[0]);
            }else{
                return Integer.compare(p1[1], p2[1]);
            }
        });
        int[] dp=new int[pairs.length];
        Arrays.fill(dp,1);
        int start,end;
        for(int i=1;i<pairs.length;i++){
            start=pairs[i][0];
            end=pairs[i][1];
            for(int j=0;j<i;j++){
                if(pairs[j][1]<start){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        return dp[pairs.length-1];

    }
    /**
     * 以index结尾的最长数链,递归尝试
     * @param pairs
     * @param index
     * @return
     */
    public int f(int[][] pairs,int index){
        if(index==0) return 1;
        int ans=1;
        int start=pairs[index][0];
        int end=pairs[index][1];
        for(int i=0;i<index;i++){
            if(pairs[i][1]<start){
                ans=Math.max(ans,f(pairs,i)+1);
            }
        }
        return ans;
    }

}
