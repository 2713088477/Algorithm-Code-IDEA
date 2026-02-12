package ZuoVideo45;

import java.util.Arrays;

public class Code02_Solution {

    public static int high;
    public static int MAX_SIZE = 1000000;
    public static int[][] node = new int[MAX_SIZE][2];
    public static int cnt;
    public static void build(){
        cnt=1;
    }
    public static void clear(){
        for(int i=1;i<=cnt;i++){
            Arrays.fill(node[i],0);
        }
    }
    public static void insert(int num){
        int cur = 1;
        for(int i=high-1;i>=0;i--){
            int path = (num>>i) & 1;
            if(node[cur][path]==0){
                node[cur][path]=++cnt;
            }
            cur = node[cur][path];
        }
    }
    public static int solve(int num){
        int ans = 0;
        int cur =1;
        for(int i=high-1;i>=0;i--){
            int status = (num>>i) & 1;
            int want = status ^ 1;
            if(node[cur][want]==0){
                want ^=1;
            }
            ans |= (want^status)<<i;
            cur = node[cur][want];
        }
        return ans;
    }
    public int findMaximumXOR(int[] nums) {
        int value = Integer.MIN_VALUE;
        for (int num : nums) {
            value = Math.max(num,value);
        }
        high = 32-Integer.numberOfLeadingZeros(value);
        build();
        for (int num : nums) {
            //将每个数字加入到前缀树中
            insert(num);
        }
        int ans = 0;
        for (int num : nums) {
            //处理每个数字
            ans = Math.max(ans,solve(num));
        }
        clear();
        return ans;
    }

}
