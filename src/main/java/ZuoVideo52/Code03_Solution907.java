package ZuoVideo52;

//测试链接:https://leetcode.cn/problems/sum-of-subarray-minimums/description/
public class Code03_Solution907 {
    public static long mod = (long)1e9+7L;
    public static int MAX_SIZE = (int)3E4+1;
    public static int[] stack = new int[MAX_SIZE];
    public static int[][] ans = new int[MAX_SIZE][2];
    public int sumSubarrayMins(int[] arr) {
        int top=0,curIndex;
        for(int i=0;i<arr.length;i++){
            while(top > 0 && arr[i] <= arr[stack[top-1]]){
                //弹出
                curIndex = stack[--top];
                ans[curIndex][1] = i;
                ans[curIndex][0] = top-1 >=0 ? stack[top-1]:-1;
            }
            stack[top++] = i;
        }
        //清算
        while(top>0){
            curIndex = stack[--top];
            ans[curIndex][1] = arr.length;
            ans[curIndex][0] = top-1 >=0 ? stack[top-1]:-1;
        }
        long answer = 0;
        for(int i=0;i<arr.length;i++){
            answer = (answer%mod + (((long)(i- (long)ans[i][0]) * (long)(ans[i][1]-i))%mod * (long)arr[i])%mod)%mod;
        }
        return (int)(answer%mod);
    }

}
