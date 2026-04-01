package ZuoVideo52;

//测试链接:https://leetcode.cn/problems/daily-temperatures/
public class Code02_Solution739 {
    public static int MAX_SIZE = (int)1E5+1;
    public static int[] stack = new int[MAX_SIZE];
    public static int n;
    public int[] dailyTemperatures(int[] temperatures) {
        n = temperatures.length;
        int[] ans = new int[n];
        int top = 0;
        for (int i = 0,index; i < temperatures.length; i++) {
            //寻找第一次出现比当前位置温度高的位置
            //小压大,等于的时候也压入栈
            while(top > 0 && temperatures[i] >  temperatures[stack[top-1]]){
                index = stack[--top];
                ans[index] = i-index;
            }
            stack[top++] = i;
        }
        return ans;
    }
}
