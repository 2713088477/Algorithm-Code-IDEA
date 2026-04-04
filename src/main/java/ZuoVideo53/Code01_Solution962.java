package ZuoVideo53;

//测试链接:https://leetcode.cn/problems/maximum-width-ramp/
public class Code01_Solution962 {
    public static int MAX_SIZE = (int)5E4+1;
    public static int[] stack = new int[MAX_SIZE];
    public static int sLen = 0;
    public int maxWidthRamp(int[] nums) {
        sLen = 1;
        for(int i=1;i< nums.length;i++){
            if(sLen>0 && nums[stack[sLen-1]] > nums[i]){
                stack[sLen++] = i;
            }
        }
        int ans = 0;
        for(int i=nums.length-1,curIndex;i>=0;i--){
            while(sLen>0 && nums[stack[sLen-1]]<=nums[i]){
                ans = Math.max(ans,i-stack[sLen-1]);
                sLen--;
            }
        }
        return ans;
    }
}
