package ZuoVideo55;

//测试链接:https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/
public class Code01_Solution862 {
    public static int MAX_SIZE = (int)1E5+1;
    public static long[] prefix = new long[MAX_SIZE];
    public static int[] deque = new int[MAX_SIZE];
    public static int h,t;
    public int shortestSubarray(int[] nums, int k) {
        h=t=0;
        for(int i=0;i<nums.length;i++){
            prefix[i+1] = prefix[i] + nums[i];
        }
        int ans = Integer.MAX_VALUE;
        deque[t++] = 0;
        for(int i=1;i<=nums.length;i++){
            //如果h满足要求
            while (h<t && prefix[i]-prefix[deque[h]]>=k){
                ans = Math.min(ans,i-deque[h]);
                h++;
            }
            while( h<t && prefix[i]<=prefix[deque[t-1]]){
                t--;
            }
            deque[t++] = i;
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}
