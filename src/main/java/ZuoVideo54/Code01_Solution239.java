package ZuoVideo54;

//测试链接:https://leetcode.cn/problems/sliding-window-maximum/
public class Code01_Solution239 {
    public static int MAX_SIZE = (int)1E5+1;
    public static int[] deque = new int[MAX_SIZE];
    public static int h,t;
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        h= 0;t=0;
        for(int i=0;i<nums.length;i++){
            if(i-k+1<0){
                while(h<t && nums[deque[t-1]] <= nums[i]){
                    t--;
                }
                deque[t++] = i;
                continue;
            }
            //入队列
            while(h<t && nums[deque[t-1]] <= nums[i]){
                t--;
            }
            deque[t++] = i;
            //更新答案
            ans[i-k+1]=nums[deque[h]];
            //出队列
            if(deque[h]==i-k+1){
                h++;
            }
        }
        return ans;
    }
}
